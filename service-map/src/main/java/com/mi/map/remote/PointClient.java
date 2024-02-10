package com.mi.map.remote;

import com.mi.common.constant.MapConstants;
import com.mi.common.dto.PointDTO;
import com.mi.common.dto.ResponseResult;
import com.mi.common.request.PointRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * ClassName:  PointClient
 * Description: 调用猎鹰服务实现轨迹点上传
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class PointClient {

    @Value("${map.key}")
    private String mapKey;

    @Value("${map.sid}")
    private String mapSid;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseResult upload (PointRequest pointRequest){
        // &key=<用户的key>
        // 拼装请求的url
        StringBuilder url = new StringBuilder();
        url.append(MapConstants.POINT_UPLOAD_URL);
        url.append("?");
        url.append("key="+mapKey);
        url.append("&");
        url.append("sid="+mapSid);
        url.append("&");
        url.append("tid="+pointRequest.getTid());
        url.append("&");
        url.append("trid="+pointRequest.getTrid());
        url.append("&");
        url.append("points=");
        PointDTO[] points = pointRequest.getPoints();
        url.append("%5B");
        for (PointDTO p : points
        ) {
            url.append("%7B");
            String locatetime = p.getLocatetime();
            String location = p.getLocation();
            url.append("%22location%22");
            url.append("%3A");
            url.append("%22"+location+"%22");
            url.append("%2C");

            url.append("%22locatetime%22");
            url.append("%3A");
            url.append(locatetime);

            url.append("%7D");
        }
        url.append("%5D");

        System.out.println("上传位置请求："+url.toString());
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(URI.create(url.toString()), null, String.class);
        System.out.println("上传位置响应："+stringResponseEntity.getBody());

        return ResponseResult.success();
    }

}
