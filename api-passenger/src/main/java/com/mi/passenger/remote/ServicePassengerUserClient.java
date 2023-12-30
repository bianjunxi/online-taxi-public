package com.mi.passenger.remote;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.VerificationCodeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: ServicePassengerUserClient
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@FeignClient(name = "service-passenger-user")
public interface ServicePassengerUserClient {

    @RequestMapping(method = RequestMethod.POST,value = "/user")
   ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO dto);

}
