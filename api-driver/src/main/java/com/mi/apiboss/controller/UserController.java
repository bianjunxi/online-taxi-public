package com.mi.apiboss.controller;

import com.mi.apiboss.service.UserService;
import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DriverUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:  UserController
 * Description: 司机信息
 *
 * @author Jay
 * @version v1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/user")
    public ResponseResult updateUser(@RequestBody DriverUser driverUser){
        return userService.updateUser(driverUser);
    }

}
