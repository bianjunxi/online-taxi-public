package com.mi.map.remote;

import com.mi.common.constant.MapConstants;
import com.mi.common.dto.ResponseResult;
import com.mi.common.response.ServiceResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName:  ServiceClient
 * Description: 调用猎鹰服务创建轨迹服务
 *
 * @author Jay
 * @version v1.0
 */
@Service
public class ServiceClient {

    @Value("${map.key}")
    private String mapKey;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseResult add(String name) {
        //拼装请求的url
        StringBuilder url = new StringBuilder();
        url.append(MapConstants.SERVICE_ADD_URL);
        url.append("?");
        url.append("key=" + mapKey);
        url.append("&");
        url.append("name=" + name);

        ResponseEntity<String> forEntity = restTemplate.postForEntity(url.toString(), null, String.class);
        String body = forEntity.getBody();
        JSONObject result = JSONObject.fromObject(body);
        String sid = result.getJSONObject("data").getString("sid");

        ServiceResponse response = new ServiceResponse();
        response.setSid(sid);

        return ResponseResult.success(response);
    }

}
