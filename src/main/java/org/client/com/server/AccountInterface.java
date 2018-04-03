package org.client.com.server;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.client.com.server.model.AccountModel;
import org.client.com.util.resultJson.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;

public interface AccountInterface {

    @RequestLine("GET /account/acc?account={account}")
    ResponseResult<AccountModel> getAccount(@Param("account") String account);

    @RequestLine("GET /account/id?id={id}")
    ResponseResult<AccountModel> getById(@Param("id") String id);

    @Headers("Content-Type: application/json;charset=UTF-8")
    @RequestLine("POST /account/account")
    @Body("model={model}")
    ResponseResult<AccountModel> register(@RequestBody AccountModel model);
}
