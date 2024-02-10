package com.mi.common.dto;

import lombok.Data;

/**
 * ClassName:  PointDTO
 * Description: 轨迹点上传请求参数对象
 *
 * @author Jay
 * @version v1.0
 */
@Data
public class PointDTO {

    private String location;

    private String locatetime;
}
