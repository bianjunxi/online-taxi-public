package com.mi.apiboss.remote;

import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DriverUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName:  ServiceDriverUserClient
 * Description: 远程调用service-driver-user
 *
 * @author Jay
 * @version v1.0
 */
@FeignClient("service-driver-user")
public interface ServiceDriverUserClient {
    @PutMapping("/user")
    ResponseResult updateUser(@RequestBody DriverUser driverUser);
}
