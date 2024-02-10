package com.mi.apiboss.remote;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.PointRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName:  ServiceMapClient
 * Description: 远程调用map微服务
 *
 * @author Jay
 * @version v1.0
 */
@FeignClient("service-map")
public interface ServiceMapClient {
    @RequestMapping(method = RequestMethod.POST, value = "/point/upload")
    ResponseResult upload(@RequestBody PointRequest pointRequest);
}
