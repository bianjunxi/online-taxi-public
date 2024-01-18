package com.mi.map.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:  TestController
 * Description: 测试
 *
 * @author Jay
 * @version v1.0
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String  test(){
        return "test service-map";
    }

}
