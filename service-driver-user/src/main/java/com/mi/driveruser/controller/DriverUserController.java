package com.mi.driveruser.controller;

import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DriverUser;
import com.mi.driveruser.service.DriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:  DriverUserController
 * Description: 司机信息controller
 *
 * @author Jay
 * @version v1.0
 */
@RestController
public class DriverUserController {

    @Autowired
    private DriverUserService driverUserService;

    @PostMapping("/user")
    public ResponseResult addUser(@RequestBody DriverUser driverUser){
        return driverUserService.addDriverUser(driverUser);
    }

}
