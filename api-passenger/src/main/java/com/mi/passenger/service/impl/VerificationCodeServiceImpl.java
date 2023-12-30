package com.mi.passenger.service.impl;

import ch.qos.logback.core.subst.Token;
import com.mi.common.constant.CommonStatusEnum;
import com.mi.common.dto.NumberCodeResponse;
import com.mi.common.dto.TokenResponse;
import com.mi.common.request.ResponseResult;
import com.mi.passenger.remote.ServiceVerificationCodeClient;
import com.mi.passenger.service.VerificationCodeService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
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
        //key,value,过期时间
        String key = generatorKeyByPhone(passengerPhone);
        redisTemplate.opsForValue().set(key,numberCode+"",2, TimeUnit.MINUTES);

        // 通过短信服务商,将对应的验证码发送到手机上


        return ResponseResult.success("");
    }

    /**
     * 根据手机号,生成key
     * @param passengerPhone 手机号
     * @return
     */
    private String generatorKeyByPhone(String passengerPhone){
        return VERIFICATION_CODE_PREFIX + passengerPhone;
    }

    /**
     * 校验验证码
     *
     * @param passengerPhone   手机号
     * @param verificationCode 验证码
     * @return
     */
    @Override
    public ResponseResult checkCode(String passengerPhone, String verificationCode) {
        // 根据手机号,从redis中获取验证码
        // 生成key
        String key = generatorKeyByPhone(passengerPhone);
        // 获取value
        String codeRedis = redisTemplate.opsForValue().get(key);

        // 校验验证码
        if (StringUtils.isBlank(codeRedis)){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getMessage());
        }
        if (!codeRedis.trim().equals(verificationCode.trim())){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getMessage());
        }

        // 判断原来是否有用户,并进行对应的处理
        System.out.println("判断原来是否有用户,并进行对应的处理");

        // 颁发令牌
        System.out.println("颁发令牌");

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken("token value");

        return ResponseResult.success(tokenResponse);
    }
}
