package com.mi.map.controller;

import com.mi.common.dto.ResponseResult;
import com.mi.map.service.ServiceFromMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:  serviceController
 * Description: 创建轨迹服务
 *
 * @author Jay
 * @version v1.0
 */
@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceFromMapService serviceFromMapService;

    @PostMapping("/add")
    public ResponseResult add(String name){
        return serviceFromMapService.add(name);
    }

}
