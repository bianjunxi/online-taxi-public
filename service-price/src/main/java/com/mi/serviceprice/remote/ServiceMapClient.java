package com.mi.serviceprice.remote;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.ForecastPriceDto;
import com.mi.common.response.DirectionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName:  ServiceMapClient
 * Description: 调用map服务的客户端
 *
 * @author Jay
 * @version v1.0
 */
@FeignClient("service-map")
public interface ServiceMapClient {
    /**
     * 调用第三方地图API返回距离和时长
     * @param dto
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/direction/driving")
    ResponseResult<DirectionResponse> driving(@RequestBody ForecastPriceDto dto);

}
