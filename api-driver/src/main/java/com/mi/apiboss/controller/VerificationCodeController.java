package com.mi.apiboss.controller;

import com.mi.apiboss.service.VerificationCodeService;
import com.mi.common.dto.ResponseResult;
import com.mi.common.request.VerificationCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:  VerificationCodeController
 * Description: 司机用户登录
 *
 * @author Jay
 * @version v1.0
 */
@RestController
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @PostMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO dto){
        return verificationCodeService.checkAndSendVerificationCode(dto);
    }

}
