package com.mi.map.service;

import com.mi.common.dto.ResponseResult;
import com.mi.common.response.TrackResponse;

/**
 * ClassName:  TrackService
 * Description: 创建轨迹
 *
 * @author Jay
 * @version v1.0
 */
public interface TrackService {

    /**
     * 调用API创建轨迹
     * @param tid
     * @return
     */
    ResponseResult<TrackResponse> add(String tid);

}
