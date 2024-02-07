package com.mi.apiboss.service;

import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DriverUser;

/**
 * ClassName:  DriverUserService
 * Description: 司机信息
 *
 * @author Jay
 * @version v1.0
 */
public interface DriverUserService {
    /**
     * 插入司机信息
     * @param driverUser 司机信息
     * @return
     */
    ResponseResult addDriverUser(DriverUser driverUser);

    /**
     * 修改司机信息
     * @param driverUser 司机信息
     * @return
     */
    ResponseResult updateDriverUser(DriverUser driverUser);
}
