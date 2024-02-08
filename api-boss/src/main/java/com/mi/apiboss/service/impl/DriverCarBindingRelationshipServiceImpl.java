package com.mi.apiboss.service.impl;


import com.mi.apiboss.remote.DriverUserClient;
import com.mi.apiboss.service.DriverCarBindingRelationshipService;
import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DriverCarBindingRelationship;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Jay
 * @since 2024-02-08
 */
@Service
@Slf4j
public class DriverCarBindingRelationshipServiceImpl implements DriverCarBindingRelationshipService {

    @Autowired
    private DriverUserClient driverUserClient;

    /**
     * 司机车辆关系绑定
     *
     * @param driverCarBindingRelationship
     * @return
     */
    @Override
    public ResponseResult bind(DriverCarBindingRelationship driverCarBindingRelationship) {
        return driverUserClient.bind(driverCarBindingRelationship);
    }

    /**
     * 司机车辆关系解绑
     *
     * @param driverCarBindingRelationship
     * @return
     */
    @Override
    public ResponseResult unBind(DriverCarBindingRelationship driverCarBindingRelationship) {
        return driverUserClient.ubBind(driverCarBindingRelationship);
    }
}
