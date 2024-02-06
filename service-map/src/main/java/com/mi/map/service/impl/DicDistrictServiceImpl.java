package com.mi.map.service.impl;

import com.mi.common.constant.CommonStatusEnum;
import com.mi.common.constant.MapConstants;
import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DicDistrict;
import com.mi.map.mapper.DicDistrictMapper;
import com.mi.map.remote.MapDistrictClient;
import com.mi.map.service.DicDistrictService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * ClassName:  DicDistrictServiceImpl
 * Description: 调用高德查询行政区划接口
 *
 * @author Jay
 * @version v1.0
 */
@Service
public class DicDistrictServiceImpl implements DicDistrictService {


    @Autowired
    private MapDistrictClient mapDistrictClient;

    @Autowired
    private DicDistrictMapper dicDistrictMapper;

    /**
     * 根据行政区划关键词查询信息
     *
     * @param keyword 行政区划
     * @return
     */
    @Override
    public ResponseResult initDicDistrict(String keyword) {
        //请求地图
        String dicDistrict = mapDistrictClient.dicDistrict(keyword);
        System.out.println(dicDistrict);

        //解析结果
        //转换为json对象
        JSONObject dicDistrictJsonObject = JSONObject.fromObject(dicDistrict);
        int status = dicDistrictJsonObject.getInt(MapConstants.STATUS);
        if (status != 1) {
            return ResponseResult.fail(CommonStatusEnum.MAP_DISTRICT_ERROR.getCode(), CommonStatusEnum.MAP_DISTRICT_ERROR.getMessage());
        }

        JSONArray countryJsonArray = dicDistrictJsonObject.getJSONArray(MapConstants.DISTRICTS);
        for (int country=0;country<countryJsonArray.size();country++){
            JSONObject countryJsonObject = countryJsonArray.getJSONObject(country);
            String countryAddressCode = countryJsonObject.getString(MapConstants.ADCODE);
            String countryAddressName = countryJsonObject.getString(MapConstants.NAME);
            String countryParentAddressCode = "0";
            String countryLevel = countryJsonObject.getString(MapConstants.LEVEL);

            insertDicDistrict(countryAddressCode,countryAddressName,countryLevel,countryParentAddressCode);

            JSONArray proviceJsonArray = countryJsonObject.getJSONArray(MapConstants.DISTRICTS);
            for (int p = 0;p< proviceJsonArray.size();p++){
                JSONObject proviceJsonObject = proviceJsonArray.getJSONObject(p);
                String proviceAddressCode = proviceJsonObject.getString(MapConstants.ADCODE);
                String proviceAddressName = proviceJsonObject.getString(MapConstants.NAME);
                String proviceParentAddressCode = countryAddressCode;
                String proviceLevel = proviceJsonObject.getString(MapConstants.LEVEL);

                insertDicDistrict(proviceAddressCode,proviceAddressName,proviceLevel,proviceParentAddressCode);

                JSONArray cityArray = proviceJsonObject.getJSONArray(MapConstants.DISTRICTS);
                for (int city = 0;city< cityArray.size();city++){
                    JSONObject cityJsonObject = cityArray.getJSONObject(city);
                    String cityAddressCode = cityJsonObject.getString(MapConstants.ADCODE);
                    String cityAddressName = cityJsonObject.getString(MapConstants.NAME);
                    String cityParentAddressCode = proviceAddressCode;
                    String cityLevel = cityJsonObject.getString(MapConstants.LEVEL);

                    insertDicDistrict(cityAddressCode,cityAddressName,cityLevel,cityParentAddressCode);

                    JSONArray districtArray = cityJsonObject.getJSONArray(MapConstants.DISTRICTS);
                    for (int d = 0;d< districtArray.size();d++){
                        JSONObject districtJsonObject = districtArray.getJSONObject(d);
                        String districtAddressCode = districtJsonObject.getString(MapConstants.ADCODE);
                        String districtAddressName = districtJsonObject.getString(MapConstants.NAME);
                        String districtParentAddressCode = cityAddressCode;
                        String districtLevel = districtJsonObject.getString(MapConstants.LEVEL);

                        if(districtLevel.equals(MapConstants.STREET)){
                            continue;
                        }

                        insertDicDistrict(districtAddressCode,districtAddressName,districtLevel,districtParentAddressCode);

                    }
                }
            }

        }

        return ResponseResult.success();
    }

    private void insertDicDistrict(String addressCode, String addressName,  String level,String parentAddressCode) {
        //数据库对象
        DicDistrict district = new DicDistrict();
        district.setAddressCode(addressCode);
        district.setAddressName(addressName);
        district.setLevel(generateLevel(level));
        district.setParentAddressCode(parentAddressCode);
        //插入数据库
        dicDistrictMapper.insert(district);
    }

    private int generateLevel(String level) {
        int levelInt = 0;
        if (level.trim().equals("province")) {
            levelInt = 1;
        } else if (level.trim().equals("city")) {
            levelInt = 2;
        } else if (level.trim().equals("district")) {
            levelInt = 3;
        } else {
            levelInt = 0;
        }
        return levelInt;
    }

}
