package com.mi.apiboss.controller;

import com.mi.apiboss.service.PointService;
import com.mi.common.dto.ResponseResult;
import com.mi.common.request.ApiDriverPointRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:  PointController
 * Description: 司机上传位置
 *
 * @author Jay
 * @version v1.0
 */
@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    private PointService pointService;

    @PostMapping("/upload")
    public ResponseResult upload(@RequestBody ApiDriverPointRequest apiDriverPointRequest){

        return pointService.upload(apiDriverPointRequest);
    }

}
