package com.mi.map.service;

import com.mi.common.dto.ResponseResult;

/**
 * ClassName:  DicDistrict
 * Description: 调用高德查询行政区划接口
 *
 * @author Jay
 * @version v1.0
 */
public interface DicDistrictService {

    /**
     * 根据行政区划关键词查询信息
     * @param keyword 行政区划
     * @return
     */
    ResponseResult initDicDistrict(String keyword);

}
