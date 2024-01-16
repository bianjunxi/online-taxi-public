package com.mi.passenger.service;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.ForecastPriceDto;

/**
 * ClassName:  ForecastPriceService
 * Description: 预估价格
 *
 * @author Jay
 * @version v1.0
 */
public interface ForecastPriceService {

    /**
     * 根据出发地和目的地经纬度 计算价格
     * @param dto 请求参数封装经纬度
     * @return ResponseResult
     */
    ResponseResult forecastPrice(ForecastPriceDto dto);

}
