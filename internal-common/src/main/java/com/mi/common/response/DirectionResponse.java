package com.mi.common.response;

import lombok.Data;

/**
 * ClassName:  DirectionResponse
 * Description: 地图服务返回实体对象
 *
 * @author Jay
 * @version v1.0
 */
@Data
public class DirectionResponse {

    private Integer distance;

    private Integer duration;

}
