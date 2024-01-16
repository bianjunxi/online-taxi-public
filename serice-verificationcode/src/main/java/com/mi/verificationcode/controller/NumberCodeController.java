package com.mi.verificationcode.controller;

import response.NumberCodeResponse;
import com.mi.common.dto.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: NumberCodeController
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@RestController
public class NumberCodeController {

    @GetMapping("/numberCode/{size}")
    public ResponseResult numberCode(@PathVariable("size") int size){
        //生成验证码
        double mathRandom = (Math.random() * 9 + 1) * (Math.pow(10,size - 1));
        int resultInt = (int) mathRandom;

        //定义返回值
        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(resultInt);

        return ResponseResult.success(response);
    }

    public static void main(String[] args) {
        double mathRandom = (Math.random() * 9 + 1) * (Math.pow(10,5));
        System.out.println(mathRandom);

        int result = (int) mathRandom;
        System.out.println(result);
    }

}
