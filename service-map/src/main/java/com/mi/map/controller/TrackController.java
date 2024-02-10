package com.mi.map.controller;

import com.mi.common.dto.ResponseResult;
import com.mi.map.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:  TrackController
 * Description: 创建轨迹
 *
 * @author Jay
 * @version v1.0
 */
@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @PostMapping("/add")
    public ResponseResult add(String tid){
        return trackService.add(tid);
    }

}
