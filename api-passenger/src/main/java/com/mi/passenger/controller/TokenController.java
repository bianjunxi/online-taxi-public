package com.mi.passenger.controller;

import com.mi.common.dto.ResponseResult;
import response.TokenResponse;
import com.mi.passenger.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: TokenController
 * Description: 双token刷新
 *
 * @author Jay
 * @version v1.0
 */
@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/refresh-token")
    public ResponseResult refreshToken(@RequestBody TokenResponse response) {
        String refreshToken = response.getRefreshToken();
        return ResponseResult.success(tokenService.refreshToken(refreshToken));
    }

}
