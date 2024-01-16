package com.mi.common.request;

import lombok.Data;

/**
 * ClassName:  ForecastPriceDto
 * Description: 接收预估价格经纬度请求体
 *
 * @author Jay
 * @version v1.0
 */
@Data
public class ForecastPriceDto {

    /**
     * 出发地经度
     */
    private String depLongitude;
    /**
     * 出发地纬度
     */
    private String depLatitude;
    /**
     * 目的地经度
     */
    private String destLongitude;
    /**
     * 目的地维度
     */
    private String destLatitude;

}
