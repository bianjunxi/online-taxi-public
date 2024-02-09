package com.mi.map.service;

import com.mi.common.dto.ResponseResult;

/**
 * ClassName:  ServiceFromMapService
 * Description: 创建轨迹服务
 *
 * @author Jay
 * @version v1.0
 */
public interface ServiceFromMapService {
    /**
     * 调用高德猎鹰服务完成轨迹服务的创建
     * @param name
     * @return
     */
    ResponseResult add(String name);

}
