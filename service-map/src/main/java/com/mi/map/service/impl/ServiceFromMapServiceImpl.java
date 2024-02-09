package com.mi.map.service.impl;

import com.mi.common.dto.ResponseResult;
import com.mi.map.remote.ServiceClient;
import com.mi.map.service.ServiceFromMapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:  ServiceFromMapServiceImpl
 * Description: 创建轨迹服务
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class ServiceFromMapServiceImpl implements ServiceFromMapService {

    @Autowired
    private ServiceClient serviceClient;

    /**
     * 调用高德猎鹰服务完成轨迹服务的创建
     *
     * @param name
     * @return
     */
    @Override
    public ResponseResult add(String name) {
        return serviceClient.add(name);
    }
}
