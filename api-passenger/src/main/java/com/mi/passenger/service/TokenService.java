package com.mi.passenger.service;

import com.mi.common.dto.ResponseResult;

/**
 * ClassName: TokenService
 * Description: 双token刷新
 *
 * @author Jay
 * @version v1.0
 */
public interface TokenService {
    /**
     * 双token刷新
     * @param refreshTokenSrc 刷新token
     * @return
     */
    ResponseResult refreshToken(String refreshTokenSrc);

}
