package com.mi.map.controller;

import com.mi.common.dto.ResponseResult;
import com.mi.map.service.DicDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:  DicDistrictController
 * Description: 调用高德行政区划查询接口
 *
 * @author Jay
 * @version v1.0
 */
@RestController
public class DicDistrictController {

    @Autowired
    private DicDistrictService dicDistrictService;

    @GetMapping("/dic-district")
    public ResponseResult initDistrict(String keyword){
        return dicDistrictService.initDicDistrict(keyword);
    }

}
