package com.mi.apiboss.remote;

import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.Car;
import com.mi.common.vo.DriverCarBindingRelationship;
import com.mi.common.vo.DriverUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, value = "/car")
    ResponseResult addCar(@RequestBody Car car);


    @PostMapping("/bind")
    ResponseResult bind(@RequestBody DriverCarBindingRelationship driverCarBindingRelationship);


    @PostMapping("/unbind")
    ResponseResult ubBind(@RequestBody DriverCarBindingRelationship driverCarBindingRelationship);

}
