package com.mi.apiboss.service.impl;

import com.mi.apiboss.remote.ServiceDriverUserClient;
import com.mi.apiboss.service.UserService;
import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DriverUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:  UserServiceImpl
 * Description: 司机信息
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    /**
     * 维护司机信息
     *
     * @param driverUser 司机实体
     * @return
     */
    @Override
    public ResponseResult updateUser(DriverUser driverUser) {
        serviceDriverUserClient.updateUser(driverUser);
        return ResponseResult.success("");
    }
}
