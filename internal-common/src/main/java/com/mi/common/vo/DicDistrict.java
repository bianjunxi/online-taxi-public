package com.mi.common.vo;

import lombok.Data;

/**
 * ClassName:  DicDistrict
 * Description: 行政区划实体类
 *
 * @author Jay
 * @version v1.0
 */
@Data
public class DicDistrict {

    private String addressCode;

    private String addressName;

    private String parentAddressCode;

    private Integer level;

}
