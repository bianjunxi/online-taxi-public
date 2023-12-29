package com.mi.passenger.service.impl;

import com.mi.common.dto.NumberCodeResponse;
import com.mi.common.request.ResponseResult;
import com.mi.passenger.remote.ServiceVerificationCodeClient;
import com.mi.passenger.service.VerificationCodeService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: VerificationCodeServiceImpl
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private ServiceVerificationCodeClient serviceVerificationCodeClient;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 乘客验证码前缀
     */
    private static final String VERIFICATION_CODE_PREFIX = "passenger_verification_code_";

    /**
     * 发送验证码
     *
     * @param passengerPhone 手机号
     * @return json
     */
    @Override
    public ResponseResult generatorCode(String passengerPhone) {
        // 调用验证码的服务,获取验证码
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationCodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();

        // 存入redis
        redisTemplate.opsForValue().set(VERIFICATION_CODE_PREFIX + passengerPhone,numberCode+"",2, TimeUnit.MINUTES);

        // 通过短信服务商,将对应的验证码发送到手机上


        return ResponseResult.success("");
    }
}
