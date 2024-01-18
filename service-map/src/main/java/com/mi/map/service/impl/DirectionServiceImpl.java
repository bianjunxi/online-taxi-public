package com.mi.map.service.impl;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.ForecastPriceDto;
import com.mi.common.response.DirectionResponse;
import com.mi.map.service.DirectionService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ClassName:  DirectionServiceImpl
 * Description: 调用第三方地图API返回距离和时长
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class DirectionServiceImpl implements DirectionService {

    /**
     * 根据起点经纬度和终点经纬度获取距离和时长
     *
     * @param dto
     * @return
     */
    @Override
    public ResponseResult driving(ForecastPriceDto dto) {

        DirectionResponse response = new DirectionResponse();
        response.setDistance(100);
        response.setDuration(200);

        return ResponseResult.success(response);
    }
}
