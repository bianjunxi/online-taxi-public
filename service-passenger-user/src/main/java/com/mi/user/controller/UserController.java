package com.mi.user.controller;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.VerificationCodeDTO;
import com.mi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserController
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseResult loginOrRegister(@RequestBody VerificationCodeDTO dto) {
        String passengerPhone = dto.getPassengerPhone();
        System.out.println("手机号:" + passengerPhone);
        return ResponseResult.success(userService.loginOrRegister(passengerPhone));
    }

}
