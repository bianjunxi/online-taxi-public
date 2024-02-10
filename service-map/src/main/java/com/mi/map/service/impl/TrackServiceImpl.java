package com.mi.map.service.impl;

import com.mi.common.dto.ResponseResult;
import com.mi.common.response.TrackResponse;
import com.mi.map.remote.TrackClient;
import com.mi.map.service.TrackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:  TrackServiceImpl
 * Description: 创建轨迹
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackClient trackClient;

    /**
     * 调用API创建轨迹
     *
     * @param tid
     * @return
     */
    @Override
    public ResponseResult<TrackResponse> add(String tid) {
        return trackClient.add(tid);
    }
}
