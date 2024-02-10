package com.mi.map.controller;

import com.mi.common.dto.ResponseResult;
import com.mi.common.request.PointRequest;
import com.mi.map.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:  PointController
 * Description: 轨迹点上传
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
    public ResponseResult upload(@RequestBody PointRequest pointRequest) {

        return pointService.upload(pointRequest);
    }
}
