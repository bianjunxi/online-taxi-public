package com.mi.passenger.service.impl;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.ForecastPriceDto;
import com.mi.passenger.service.ForecastPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import response.ForecastPriceResponse;

/**
 * ClassName:  ForecastPriceServiceImpl
 * Description: 预估价格
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class ForecastPriceServiceImpl implements ForecastPriceService {
    /**
     * 根据出发地和目的地经纬度 计算价格
     *
     * @param dto 请求参数封装经纬度
     * @return ResponseResult
     */
    @Override
    public ResponseResult forecastPrice(ForecastPriceDto dto) {

        String depLongitude = dto.getDepLongitude();
        String depLatitude = dto.getDepLatitude();
        String destLongitude = dto.getDestLongitude();
        String destLatitude = dto.getDestLatitude();

        log.info(depLongitude);
        log.info(depLatitude);
        log.info(destLongitude);
        log.info(destLatitude);

        log.info("调用计价服务,计算价格");

        ForecastPriceResponse response = new ForecastPriceResponse();
        response.setPrice(100);

        return ResponseResult.success(response);
    }
}
