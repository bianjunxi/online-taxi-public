package com.mi.map.service;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.PointRequest;

/**
 * ClassName:  PointService
 * Description: 轨迹点上传
 *
 * @author Jay
 * @version v1.0
 */
public interface PointService {
    ResponseResult upload(PointRequest pointRequest);
}
