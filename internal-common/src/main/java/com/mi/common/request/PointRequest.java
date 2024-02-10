package com.mi.common.request;

import com.mi.common.dto.PointDTO;
import lombok.Data;

/**
 * ClassName:  PointRequest
 * Description: 轨迹点上传请求参数对象
 *
 * @author Jay
 * @version v1.0
 */
@Data
public class PointRequest {
    private String tid;

    private String trid;

    private PointDTO[] points;
}
