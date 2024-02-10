package com.mi.common.request;

import com.mi.common.dto.PointDTO;
import lombok.Data;

/**
 * ClassName:  ApiDriverPointRequest
 * Description: 司机上传位置请求参数
 *
 * @author Jay
 * @version v1.0
 */
@Data
public class ApiDriverPointRequest {
    public Long carId;
    private PointDTO[] points;
}
