package com.mi.passenger.controller;

import com.mi.common.request.ResponseResult;
import com.mi.passenger.request.VerificationCodeDTO;
import com.mi.passenger.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: VerificationCodeController
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@RestController
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @GetMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO dto){
        String passengerPhone = dto.getPassengerPhone();
        return verificationCodeService.generatorCode(passengerPhone);
    }

    @PostMapping("/verification-code-check")
    public ResponseResult checkVerificationCode(@RequestBody VerificationCodeDTO dto){
        String passengerPhone = dto.getPassengerPhone();
        String verificationCode = dto.getVerificationCode();
        System.out.println("手机号:" + passengerPhone+",验证码:" + verificationCode);
        return verificationCodeService.checkCode(passengerPhone, verificationCode);
    }

}
