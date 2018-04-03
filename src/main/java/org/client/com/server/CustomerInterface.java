package org.client.com.server;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.client.com.server.model.CargoAddressModel;
import org.client.com.server.model.PersonalDataModel;
import org.client.com.util.resultJson.ResponseResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author ld
 * @name 统一远程接口类
 * @table
 * @remarks
 */
public interface CustomerInterface {

    /*****************************************************个人资料*************************************************************/

    @RequestLine("GET /personal/personal/account/{account}")
    ResponseResult<PersonalDataModel> personaldata_getByAccount(@Param("account") String account);

    @Headers("Content-Type: application/json;charset=UTF-8")
    @RequestLine("PUT /personal/personal")
    @Body("model={model}")
    ResponseResult<PersonalDataModel> personaldata_update(@RequestBody PersonalDataModel model);

    /*****************************************************收货地址*************************************************************/

    @RequestLine("GET /crgoaddress/id/{id}")
    ResponseResult<List<CargoAddressModel>> crgoaddress_findByAccId(@Param("id") String id);

    @Headers("Content-Type: application/json;charset=UTF-8")
    @RequestLine("POST /crgoaddress")
    @Body("model={model}")
    ResponseResult<CargoAddressModel> crgoaddress_add(@RequestBody CargoAddressModel model);

    @RequestLine("DELETE /crgoaddress/id/{id}")
    ResponseResult<CargoAddressModel> crgoaddress_delById(@Param("id") String id);

    @Headers("Content-Type: application/json;charset=UTF-8")
    @RequestLine("PUT /crgoaddress")
    @Body("model={model}")
    ResponseResult<CargoAddressModel> crgoaddress_update(@RequestBody CargoAddressModel model);

}
