package com.mi.apiboss.service;

import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DriverCarBindingRelationship;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jay
 * @since 2024-02-08
 */
public interface DriverCarBindingRelationshipService{

    /**
     * 司机车辆关系绑定
     * @param driverCarBindingRelationship
     * @return
     */
    ResponseResult bind(DriverCarBindingRelationship driverCarBindingRelationship);

    /**
     * 司机车辆关系解绑
     * @param driverCarBindingRelationship
     * @return
     */
    ResponseResult unBind(DriverCarBindingRelationship driverCarBindingRelationship);
}
