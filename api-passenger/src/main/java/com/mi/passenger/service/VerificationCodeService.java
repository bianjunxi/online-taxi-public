package com.mi.passenger.service;

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
    String generatorCode(String passengerPhone);

}
