package com.mi.user.service;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.VerificationCodeDTO;

/**
 * ClassName: UserService
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
public interface UserService {

    /**
     * 登录或注册
     * @param passengerPhone 手机号
     * @return
     */
    ResponseResult loginOrRegister(String passengerPhone);

    /**
     * 根据手机号查询用户信息
     * @param passengerPhone
     * @return
     */
    ResponseResult getUser(String passengerPhone);

}
