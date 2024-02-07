package com.mi.apiboss.service;

import com.mi.apiboss.remote.DriverUserClient;
import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DriverUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:  DriverUserImpl
 * Description: 司机信息
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class DriverUserImpl implements DriverUserService{

    @Autowired
    private DriverUserClient driverUserClient;

    /**
     * 插入司机信息
     *
     * @param driverUser 司机信息
     * @return
     */
    @Override
    public ResponseResult addDriverUser(DriverUser driverUser) {
        return driverUserClient.addUser(driverUser);
    }

    /**
     * 修改司机信息
     *
     * @param driverUser 司机信息
     * @return
     */
    @Override
    public ResponseResult updateDriverUser(DriverUser driverUser) {
        return driverUserClient.updateUser(driverUser);
    }
}
