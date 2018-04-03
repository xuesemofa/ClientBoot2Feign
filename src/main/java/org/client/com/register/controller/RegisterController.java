package org.client.com.register.controller;

import feign.FeignException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.client.com.register.model.RegisterModel;
import org.client.com.server.AccountInterface;
import org.client.com.server.model.AccountModel;
import org.client.com.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(value = "register", description = "注册")
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private AccountInterface anInterface;

    @ApiOperation(value = "添加账户",
            response = ResponseResult.class,
            httpMethod = "POST",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<RegisterModel> register(@Valid @RequestBody RegisterModel model,
                                                  BindingResult bindingResult) {
        ResponseResult<RegisterModel> result = new ResponseResult<>();
        try {
            if (bindingResult.hasErrors()) {
                result.setSuccess(false);
                result.setMessage(bindingResult.getFieldError().getDefaultMessage());
                return result;
            }
            if (!model.isPass()) {
                result.setSuccess(false);
                result.setMessage("两次输入的密码不一致");
                return result;
            }

            AccountModel model1 = new AccountModel();
            model1.setAccount(model.getAccount());
            model1.setPassword(model.getPassword());
            model1.setLevel("1");
            model1.setSource("移动端注册");

            ResponseResult<AccountModel> responseResult = anInterface.register(model1);
            if (responseResult.isSuccess()) {
                result.setSuccess(true);
                result.setMessage("注册成功");
                return result;
            } else {
                result.setSuccess(false);
                result.setMessage(responseResult.getMessage());
                return result;
            }
        } catch (FeignException f) {
            result.setSuccess(false);
            result.setMessage("服务通讯异常");
            return result;
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("其它异常，请联系管理员");
            return result;
        }
    }

}
