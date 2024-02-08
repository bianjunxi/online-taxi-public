package com.mi.apiboss.remote;

import com.mi.common.dto.ResponseResult;
import com.mi.common.response.DriverUserExistsResponse;
import com.mi.common.vo.DriverUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:  ServiceDriverUserClient
 * Description: 远程调用service-driver-user
 *
 * @author Jay
 * @version v1.0
 */
@FeignClient("service-driver-user")
public interface ServiceDriverUserClient {
    /**
     * 远程调用service-driver-user修改司机信息
     * @param driverUser
     * @return
     */
    @PutMapping("/user")
    ResponseResult updateUser(@RequestBody DriverUser driverUser);

    /**
     * 远程调用service-driver-user查询司机是否存在
     * @param driverPhone
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/check-driver/{driverPhone}")
    ResponseResult<DriverUserExistsResponse> checkDriver(@PathVariable("driverPhone") String driverPhone);

}
