package org.client.com.server;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.client.com.server.model.TokenModel;
import org.client.com.util.resultJson.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;

public interface TokenInterface {

    @Headers("Content-Type: application/json;charset=UTF-8")
    @RequestLine("POST /token/token")
    @Body("model={model}")
    ResponseResult<TokenModel> add(@RequestBody TokenModel model);

    @RequestLine("POST /token/updateToken")
    @Body("token={token}")
    ResponseResult<TokenModel> updateToken(@Param("token") String token);

    @RequestLine("GET /token/token/{token}")
    ResponseResult<TokenModel> getByToken(@Param("token") String token);
}
