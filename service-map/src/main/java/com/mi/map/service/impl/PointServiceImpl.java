package com.mi.map.service.impl;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.PointRequest;
import com.mi.map.remote.PointClient;
import com.mi.map.service.PointService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:  PointServiceImpl
 * Description: 轨迹点上传
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class PointServiceImpl implements PointService {

    @Autowired
    private PointClient pointClient;

    @Override
    public ResponseResult upload(PointRequest pointRequest) {
        return pointClient.upload(pointRequest);
    }
}
