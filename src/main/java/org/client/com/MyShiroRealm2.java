package org.client.com;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.client.com.server.AccountInterface;
import org.client.com.server.TokenInterface;
import org.client.com.server.model.AccountModel;
import org.client.com.server.model.TokenModel;
import org.client.com.util.base64.Base64Util;
import org.client.com.util.resultJson.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * 用于判断user
 */
@Configuration
public class MyShiroRealm2 extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(MyShiroRealm2.class);

    @Autowired
    private TokenInterface tkInterface;
    @Autowired
    private AccountInterface anInterface;

    @Override
    public String getName() {
        return "user";
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        MyUsernamePasswordToken myToken = (MyUsernamePasswordToken) token;
        if (myToken.getSignature() == null || myToken.getSignature().isEmpty()) {
            //请从新登录;
            log.info("令牌为空");
            throw new UnknownAccountException();
        }
        ResponseResult<TokenModel> result = tkInterface.getByToken(myToken.getSignature());
        if (result.isSuccess()) {
//            如果token存在判断是否过期
            long now_times = System.currentTimeMillis();
            if (result.getData().getEndTimes() <= 0 || result.getData().getEndTimes() < now_times) {
//                密钥过期,请从新登录;
                log.info("令牌过期");
                throw new UnknownAccountException();
            }

//            判断是否是作废的令牌
            if (result.getData().getIsUse().equals("Y")) {
//                令牌已作废
                log.info("令牌已用过");
                throw new UnknownAccountException();
            }
            myToken.setUsername(result.getData().getAccount());
            return new SimpleAuthenticationInfo(
                    myToken,
                    myToken.getSignature(),
                    getName()
            );
        } else {
            if (myToken.getUsername() != null && !myToken.getUsername().isEmpty()) {
                ResponseResult<AccountModel> account = anInterface.getAccount(myToken.getUsername());
                if (account.isSuccess())
                    return new SimpleAuthenticationInfo(
                            account.getData(),
                            Base64Util.decode(account.getData().getPassword()),
                            getName()
                    );
                else
                    throw new UnknownAccountException();
            } else
                //请从新登录;
                throw new UnknownAccountException();
        }
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("user");
        return info;
    }

}