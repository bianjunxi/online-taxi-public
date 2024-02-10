package com.mi.apiboss.service;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.ApiDriverPointRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ClassName:  PointService
 * Description: 司机上传位置
 *
 * @author Jay
 * @version v1.0
 */
public interface PointService {
    /**
     * 司机位置上传
     * @param apiDriverPointRequest
     * @return
     */
    ResponseResult upload(ApiDriverPointRequest apiDriverPointRequest);
}
