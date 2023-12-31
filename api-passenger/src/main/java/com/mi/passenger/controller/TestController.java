package com.mi.passenger.controller;

import com.mi.common.dto.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: TestController
 * Description:
 *
 * @author Leo
 * @version v1.0
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "test api passenger";
    }


    /**
     * 需要有身份认证
     * @return
     */
    @GetMapping("/authTest")
    public ResponseResult authTest(){
        return ResponseResult.success("auth Test");
    }

    /**
     * 没有token也能正常返回
     * @return
     */
    @GetMapping("/noAuthTest")
    public ResponseResult noAuthTest(){
        return ResponseResult.success("no auth Test");
    }


}
