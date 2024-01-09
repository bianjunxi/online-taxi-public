package com.mi.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mi.common.constant.CommonStatusEnum;
import com.mi.common.dto.ResponseResult;
import com.mi.user.mapper.PassengerUserMapper;
import com.mi.common.dto.PassengerUser;
import com.mi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PassengerUserMapper passengerUserMapper;

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
        PassengerUser passengerUser = passengerUserMapper.selectOne(Wrappers.<PassengerUser>lambdaQuery().eq(PassengerUser::getPassengerPhone, passengerPhone));
        //判断用户信息是否存在
        if (passengerUser == null) {
            //如果不存在,插入用户信息
            passengerUser = new PassengerUser();
            passengerUser.setPassengerName("用户" + passengerPhone);
            passengerUser.setPassengerPhone(passengerPhone);
            passengerUser.setPassengerGender((byte) 1);
            passengerUser.setState((byte) 0);
            passengerUser.setGmtCreate(LocalDateTime.now());
            passengerUser.setGmtModified(LocalDateTime.now());
            passengerUserMapper.insert(passengerUser);
        }

        return ResponseResult.success();
    }

    /**
     * 根据手机号查询用户信息
     *
     * @param passengerPhone
     * @return
     */
    @Override
    public ResponseResult getUser(String passengerPhone) {
        //根据手机号查询用户信息
        PassengerUser passengerUser = passengerUserMapper.selectOne(Wrappers.<PassengerUser>lambdaQuery().eq(PassengerUser::getPassengerPhone, passengerPhone));
        //判断用户信息是否存在
        if (passengerUser == null) {
            return ResponseResult.fail(CommonStatusEnum.USER_NOT_EXISTS.getCode(),CommonStatusEnum.USER_NOT_EXISTS.getMessage());
        }
        return ResponseResult.success(passengerUser);
    }
}
