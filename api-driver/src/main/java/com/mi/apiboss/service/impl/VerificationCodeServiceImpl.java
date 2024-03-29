package com.mi.apiboss.service.impl;

import com.mi.apiboss.remote.ServiceDriverUserClient;
import com.mi.apiboss.remote.ServiceVerificationcodeClient;
import com.mi.apiboss.service.VerificationCodeService;
import com.mi.common.constant.CommonStatusEnum;
import com.mi.common.constant.DriverCarConstants;
import com.mi.common.constant.IdentityConstant;
import com.mi.common.constant.TokenConstants;
import com.mi.common.dto.ResponseResult;
import com.mi.common.request.VerificationCodeDTO;
import com.mi.common.response.DriverUserExistsResponse;
import com.mi.common.response.TokenResponse;
import com.mi.common.utils.JwtUtils;
import com.mi.common.utils.RedisPrefixUtils;
import com.mi.common.vo.DriverUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:  VerificationCodeServiceImpl
 * Description: 司机用户登录
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class VerificationCodeServiceImpl implements VerificationCodeService {
    
    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;
    @Autowired
    private ServiceVerificationcodeClient serviceVerificationcodeClient;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    /**
     * 检查司机用户是否存在并发送验证码
     *
     * @param dto
     * @return
     */
    @Override
    public ResponseResult checkAndSendVerificationCode(VerificationCodeDTO dto) {
        //查询service-driver-user,该手机号的司机是否存在
        ResponseResult<DriverUserExistsResponse> driverUserExistsResponseResponseResult = serviceDriverUserClient.checkDriver(dto.getDriverPhone());
        DriverUserExistsResponse data = driverUserExistsResponseResponseResult.getData();
        int ifExists = data.getIfExists();
        if (ifExists == DriverCarConstants.DRIVER_NOT_EXISTS){
            return ResponseResult.fail(CommonStatusEnum.DRIVER_NOT_EXITST);
        }
        //获取验证码
        int numberCode = serviceVerificationcodeClient.getNumberCode(6).getData().getNumberCode();
        log.info("验证码:"+numberCode);
        //调用第三方发送验证码

        //存入redis
        String key = RedisPrefixUtils.generatorKeyByPhone(dto.getDriverPhone(), IdentityConstant.DRIVER_IDENTITY);
        stringRedisTemplate.opsForValue().set(key,numberCode+"",2, TimeUnit.MINUTES);

        return ResponseResult.success("");
    }


    /**
     * 校验验证码
     *
     * @param driverPhone   手机号
     * @param verificationCode 验证码
     * @return
     */
    @Override
    public ResponseResult checkCode(String driverPhone, String verificationCode) {
        // 根据手机号,从redis中获取验证码
        // 生成key
        String key = RedisPrefixUtils.generatorKeyByPhone(driverPhone,IdentityConstant.DRIVER_IDENTITY);
        // 获取value
        String codeRedis = stringRedisTemplate.opsForValue().get(key);

        // 校验验证码
        if (StringUtils.isBlank(codeRedis)){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getMessage());
        }
        if (!codeRedis.trim().equals(verificationCode.trim())){
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(),CommonStatusEnum.VERIFICATION_CODE_ERROR.getMessage());
        }


        // 颁发令牌
        String accessToken = JwtUtils.generateToken(driverPhone, IdentityConstant.DRIVER_IDENTITY, TokenConstants.ACCESS_TOKEN_TYPE);
        String refreshToken = JwtUtils.generateToken(driverPhone, IdentityConstant.DRIVER_IDENTITY,TokenConstants.REFRESH_TOKEN_TYPE);

        // 将token存储到redis
        String accessTokenKey = RedisPrefixUtils.generatorTokenKey(driverPhone, IdentityConstant.DRIVER_IDENTITY,TokenConstants.ACCESS_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(accessTokenKey,accessToken,30, TimeUnit.DAYS);
        String refreshTokenKey = RedisPrefixUtils.generatorTokenKey(driverPhone, IdentityConstant.DRIVER_IDENTITY,TokenConstants.REFRESH_TOKEN_TYPE);
        stringRedisTemplate.opsForValue().set(refreshTokenKey,refreshToken,31, TimeUnit.DAYS);

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setAccessToken(accessToken);
        tokenResponse.setRefreshToken(refreshToken);

        return ResponseResult.success(tokenResponse);
    }


}
