package com.mi.passenger.controller;

import com.mi.common.request.ResponseResult;
import com.mi.passenger.request.VerificationCodeDTO;
import com.mi.passenger.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
