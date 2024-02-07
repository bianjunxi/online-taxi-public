package com.mi.apiboss.remote;

import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DriverUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName:  DriverUserClient
 * Description: 远程调用service-driver-user
 *
 * @author Jay
 * @version v1.0
 */
@FeignClient("service-driver-user")
public interface DriverUserClient {

    @RequestMapping(method = RequestMethod.POST,value = "/user")
    ResponseResult addUser(@RequestBody DriverUser driverUser);


    @RequestMapping(method = RequestMethod.PUT,value = "/user")
    ResponseResult updateUser(@RequestBody DriverUser driverUser);

}
