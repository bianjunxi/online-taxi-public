package com.mi.passenger.service;

import com.mi.common.dto.ResponseResult;

/**
 * ClassName: UserService
 * Description: 获取登录乘客用户信息
 *
 * @author Jay
 * @version v1.0
 */
public interface UserService {

    /**
     * 获取登录乘客用户信息
     *
     * @param accessToken
     * @return
     */
    ResponseResult getUserByAccessToken(String accessToken);

}
