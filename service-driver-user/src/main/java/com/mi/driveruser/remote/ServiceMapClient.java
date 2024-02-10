package com.mi.driveruser.remote;


import com.mi.common.dto.ResponseResult;
import com.mi.common.response.TerminalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-map")
public interface ServiceMapClient {
    @RequestMapping(method = RequestMethod.POST, value = "/terminal/add")
    ResponseResult<TerminalResponse> addTerminal(@RequestParam String name);
}
