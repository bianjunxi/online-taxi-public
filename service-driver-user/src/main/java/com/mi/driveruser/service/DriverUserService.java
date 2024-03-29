package com.mi.driveruser.service;

import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DriverUser;

/**
 * ClassName:  DriverUserService
 * Description: 司机信息管理service
 *
 * @author Jay
 * @version v1.0
 */
public interface DriverUserService {
    /**
     * 插入司机信息
     * @param driverUser 司机实体类
     * @return
     */
    ResponseResult addDriverUser(DriverUser driverUser);

    /**
     * 修改司机信息
     * @param driverUser 司机实体类
     * @return
     */
    ResponseResult updateDriverUser(DriverUser driverUser);

    /**
     * 根据手机号查询司机
     * @param driverPhone
     * @return
     */
    String getDriverUserByPhone(String driverPhone);

}
