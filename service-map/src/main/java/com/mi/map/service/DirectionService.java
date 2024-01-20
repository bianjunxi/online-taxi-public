package com.mi.map.service;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.ForecastPriceDto;
import com.mi.common.response.DirectionResponse;

/**
 * ClassName:  DirectionService
 * Description: 调用第三方地图API返回距离和时长
 *
 * @author Jay
 * @version v1.0
 */
public interface DirectionService {

    /**
     * 根据起点经纬度和终点经纬度获取距离和时长
     * @param dto
     * @return
     */
    ResponseResult driving(ForecastPriceDto dto);

}
