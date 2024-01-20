package com.mi.map.remote;

import com.mi.common.constant.MapConstants;
import com.mi.common.request.ForecastPriceDto;
import com.mi.common.response.DirectionResponse;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:  DirectionController
 * Description: 调用高德客户端
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class DirectionClient {

    @Value("${map.key}")
    private String mapKey;
    @Autowired
    private RestTemplate restTemplate;

    public DirectionResponse direction(ForecastPriceDto dto){
        //组装请求调用url
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(MapConstants.DIRECTION_URL);
        urlBuilder.append("?");
        urlBuilder.append("origin=" + dto.getDepLongitude() + "," + dto.getDepLatitude());
        urlBuilder.append("&");
        urlBuilder.append("destination=" + dto.getDestLongitude() + "," + dto.getDestLatitude());
        urlBuilder.append("&");
        urlBuilder.append("extensions=base");
        urlBuilder.append("&");
        urlBuilder.append("output=json");
        urlBuilder.append("&");
        urlBuilder.append("key=" + mapKey);
        log.info(urlBuilder.toString());
        //调用高德接口
        ResponseEntity<String> directionEntity = restTemplate.getForEntity(urlBuilder.toString(), String.class);
        //解析接口
        return parseDirectionEntity(directionEntity.getBody());
    }

    private static DirectionResponse parseDirectionEntity(String body) {
        DirectionResponse response = null;

        try {
            // 避免请求参数错误响应错误的json 按照正常响应获取报错
            response = new DirectionResponse();
            // 最外层json
            JSONObject result = JSONObject.fromObject(body);
            if (result.has(MapConstants.STATUS)){
                int status = result.getInt(MapConstants.STATUS);
                if (status == 1){
                    JSONObject jsonObject = result.getJSONObject(MapConstants.ROUTE);
                    JSONArray pathArray = jsonObject.getJSONArray(MapConstants.PATHS);
                    JSONObject pathObject = pathArray.getJSONObject(0);
                    if (pathObject.has(MapConstants.DISTANCE)){
                        response.setDistance(pathObject.getInt(MapConstants.DISTANCE));
                    }
                    if (pathObject.has(MapConstants.DURATION)){
                        response.setDuration(pathObject.getInt(MapConstants.DURATION));
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return response;
    }

}
