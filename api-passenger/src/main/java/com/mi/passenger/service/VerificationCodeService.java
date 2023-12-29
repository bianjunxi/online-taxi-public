package com.mi.passenger.service;

import com.mi.common.request.ResponseResult;

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

}
