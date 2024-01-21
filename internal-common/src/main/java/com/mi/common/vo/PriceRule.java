package com.mi.common.vo;

import lombok.Data;

/**
 * ClassName:  PriceRule
 * Description: 计价规则实体类
 *
 * @author Jay
 * @version v1.0
 */
@Data
public class PriceRule {

    private String cityCode;

    private String vehicleCode;

    private Double startFare;

    private Integer startMile;

    private Double unitPricePerMile;

    private Double unitPricePerMinute;

}
