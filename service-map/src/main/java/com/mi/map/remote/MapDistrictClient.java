package com.mi.map.remote;

import com.mi.common.constant.MapConstants;
import com.mi.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:  MapDistrictClient
 * Description: 远程调用地图行政区划查询接口
 *
 * @author Jay
 * @version v1.0
 */
@Service
public class MapDistrictClient {

    @Value("${map.key}")
    private String mapKey;

    @Autowired
    private RestTemplate restTemplate;

    public String dicDistrict(String keyword) {
        //拼装请求的url
        StringBuilder url = new StringBuilder();
        url.append(MapConstants.DISTRICT_URL);
        url.append("?");
        url.append("keywords=" + keyword);
        url.append("&");
        url.append("subdistrict=3");
        url.append("&");
        url.append("key=" + mapKey);

        return restTemplate.getForEntity(url.toString(),String.class).getBody();
    }

}
