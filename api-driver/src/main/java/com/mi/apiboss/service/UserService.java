package com.mi.apiboss.service;

import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DriverUser;

/**
 * ClassName:  UserService
 * Description: 司机信息
 *
 * @author Jay
 * @version v1.0
 */
public interface UserService {
    /**
     * 维护司机信息
     * @param driverUser 司机实体
     * @return
     */
    ResponseResult updateUser(DriverUser driverUser);
}
