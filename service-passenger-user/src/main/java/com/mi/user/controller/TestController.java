package com.mi.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: TestController
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "service-passenger-user";
    }

}
