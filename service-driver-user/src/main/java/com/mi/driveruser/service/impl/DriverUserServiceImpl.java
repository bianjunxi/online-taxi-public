package com.mi.driveruser.service.impl;

import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DriverUser;
import com.mi.driveruser.mapper.DriverUserMapper;
import com.mi.driveruser.service.DriverUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * ClassName:  DriverUserServiceImpl
 * Description: 司机信息管理service
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class DriverUserServiceImpl implements DriverUserService {

    @Autowired
    private DriverUserMapper driverUserMapper;

    /**
     * 插入司机信息
     *
     * @param driverUser 司机实体类
     * @return
     */
    @Override
    public ResponseResult addDriverUser(DriverUser driverUser) {
        driverUser.setGmtCreate(LocalDateTime.now());
        driverUser.setGmtModified(LocalDateTime.now());
        driverUserMapper.insert(driverUser);
        return ResponseResult.success("");
    }
}
