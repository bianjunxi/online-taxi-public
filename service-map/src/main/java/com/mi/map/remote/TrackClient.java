package com.mi.map.remote;

import com.mi.common.constant.MapConstants;
import com.mi.common.dto.ResponseResult;
import com.mi.common.response.TrackResponse;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:  TrackClient
 * Description: 调用第三方创建轨迹
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class TrackClient {
    @Value("${map.key}")
    private String mapKey;

    @Value("${map.sid}")
    private String mapSid;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseResult<TrackResponse> add(String tid){

        // &key=<用户的key>
        // 拼装请求的url
        StringBuilder url = new StringBuilder();
        url.append(MapConstants.TRACK_ADD_URL);
        url.append("?");
        url.append("key="+mapKey);
        url.append("&");
        url.append("sid="+mapSid);
        url.append("&");
        url.append("tid="+tid);
        log.info("高德地图创建轨迹请求："+url);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url.toString(), null, String.class);
        String body = stringResponseEntity.getBody();
        log.info("高德地图创建轨迹响应："+body);
        JSONObject result = JSONObject.fromObject(body);
        JSONObject data = result.getJSONObject("data");
        // 轨迹id
        String trid = data.getString("trid");
        // 轨迹名称
        String trname = "";
        if (data.has("trname")){
            trname = data.getString("trname");
        }

        TrackResponse trackResponse = new TrackResponse();
        trackResponse.setTrid(trid);
        trackResponse.setTrname(trname);


        return ResponseResult.success(trackResponse);
    }
}
