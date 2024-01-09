package com.mi.passenger.remote;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.VerificationCodeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: ServicePassengerUserClient
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@FeignClient(name = "service-passenger-user")
public interface ServicePassengerUserClient {

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO dto);

    @GetMapping("/user/{phone}")
    ResponseResult getUser(@PathVariable("phone") String passengerPhone);

}
