package com.mi.passenger.remote;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.ForecastPriceDto;
import com.mi.common.response.ForecastPriceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName:  ServicePriceClient
 * Description: 调用预估价格服务
 *
 * @author Jay
 * @version v1.0
 */
@FeignClient("service-price")
public interface ServicePriceClient {
    /**
     * 调用预估价格服务
     * @param dto
     * @return
     */
    @PostMapping("/forecast-price")
    ResponseResult<ForecastPriceResponse> forecastPrice(@RequestBody ForecastPriceDto dto);
}
