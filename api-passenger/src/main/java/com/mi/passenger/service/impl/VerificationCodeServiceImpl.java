package com.mi.passenger.service.impl;

import com.mi.common.constant.CommonStatusEnum;
import com.mi.common.constant.IdentityConstant;
import com.mi.common.constant.TokenConstants;
import com.mi.common.response.NumberCodeResponse;
import com.mi.common.response.TokenResponse;
import com.mi.common.dto.ResponseResult;
import com.mi.common.request.VerificationCodeDTO;
import com.mi.common.utils.RedisPrefixUtils;
import com.mi.passenger.remote.ServicePassengerUserClient;
import com.mi.passenger.remote.ServiceVerificationCodeClient;
import com.mi.passenger.service.VerificationCodeService;
import com.mi.common.utils.JwtUtils;
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
        String key = RedisPrefixUtils.generatorKeyByPhone(passengerPhone,IdentityConstant.PASSENGER_IDENTITY);
        redisTemplate.opsForValue().set(key,numberCode+"",2, TimeUnit.MINUTES);

        // 通过短信服务商,将对应的验证码发送到手机上


        return ResponseResult.success("");
    }

    @Autowired
    private ServicePassengerUserClient servicePassengerUserClient;

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
        String key = RedisPrefixUtils.generatorKeyByPhone(passengerPhone,IdentityConstant.PASSENGER_IDENTITY);
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
        VerificationCodeDTO verificationCodeDTO = new VerificationCodeDTO();
        verificationCodeDTO.setPassengerPhone(passengerPhone);
        servicePassengerUserClient.loginOrRegister(verificationCodeDTO);

        // 颁发令牌
        String accessToken = JwtUtils.generateToken(passengerPhone, IdentityConstant.PASSENGER_IDENTITY, TokenConstants.ACCESS_TOKEN_TYPE);
        String refreshToken = JwtUtils.generateToken(passengerPhone, IdentityConstant.PASSENGER_IDENTITY,TokenConstants.REFRESH_TOKEN_TYPE);

        // 将token存储到redis
        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(passengerPhone, IdentityConstant.PASSENGER_IDENTITY,TokenConstants.ACCESS_TOKEN_TYPE);
        redisTemplate.opsForValue().set(accessTokenKey,accessToken,30, TimeUnit.DAYS);
        String refreshTokenKey = RedisPrefixUtils.generatorTokenKey(passengerPhone, IdentityConstant.PASSENGER_IDENTITY,TokenConstants.REFRESH_TOKEN_TYPE);
        redisTemplate.opsForValue().set(refreshTokenKey,refreshToken,31, TimeUnit.DAYS);

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessToken);
        tokenResponse.setRefreshToken(refreshToken);

        return ResponseResult.success(tokenResponse);
    }
}
