package com.mi.passenger.service.impl;

import com.mi.common.dto.ResponseResult;
import com.mi.common.dto.TokenResult;
import com.mi.common.utils.JwtUtils;
import com.mi.passenger.remote.ServicePassengerUserClient;
import com.mi.passenger.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private ServicePassengerUserClient passengerUserClient;

    /**
     * 获取登录乘客用户信息
     *
     * @param accessToken
     * @return
     */
    @Override
    public ResponseResult getUserByAccessToken(String accessToken) {
        log.info("accessToken:" + accessToken);

        //解析accessToken,拿到手机号
        TokenResult result = JwtUtils.checkToken(accessToken);
        String phone = result.getPhone();
        log.info("手机号:" + phone);

        //根据手机号查询用户信息
        return ResponseResult.success(passengerUserClient.getUser(phone).getData());
    }
}
