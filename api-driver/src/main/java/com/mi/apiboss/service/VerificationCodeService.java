package com.mi.apiboss.service;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.VerificationCodeDTO;

/**
 * ClassName:  VerificationCodeService
 * Description: 司机用户登录
 *
 * @author Jay
 * @version v1.0
 */
public interface VerificationCodeService {
    /**
     * 检查司机用户是否存在并发送验证码
     * @param dto
     * @return
     */
    ResponseResult checkAndSendVerificationCode(VerificationCodeDTO dto);


    /**
     * 校验验证码
     * @param driverPhone 手机号
     * @param verificationCode 验证码
     * @return
     */
    ResponseResult checkCode(String driverPhone,String verificationCode);

}
