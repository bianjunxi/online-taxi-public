package com.mi.passenger.service;

import com.mi.common.dto.ResponseResult;

/**
 * ClassName: VerificationCodeService
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
public interface VerificationCodeService {

    /**
     * 发送验证码
     * @param passengerPhone 手机号
     * @return json
     */
    ResponseResult generatorCode(String passengerPhone);

    /**
     * 校验验证码
     * @param passengerPhone 手机号
     * @param verificationCode 验证码
     * @return
     */
    ResponseResult checkCode(String passengerPhone,String verificationCode);

}
