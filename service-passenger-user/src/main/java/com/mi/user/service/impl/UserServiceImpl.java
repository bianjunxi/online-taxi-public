package com.mi.user.service.impl;

import com.mi.common.dto.ResponseResult;
import com.mi.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 登录或注册
     *
     * @param passengerPhone 手机号
     * @return
     */
    @Override
    public ResponseResult loginOrRegister(String passengerPhone) {
        System.out.println("user service被调用,手机号" + passengerPhone);
        //根据手机号查询用户信息

        //判断用户信息是否存在

        //如果不存在,插入用户信息

        return ResponseResult.success();
    }
}
