package com.mi.passenger.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.mi.common.constant.TokenConstants;
import com.mi.common.dto.ResponseResult;
import com.mi.common.dto.TokenResult;
import com.mi.common.utils.JwtUtils;
import com.mi.common.utils.RedisPrefixUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * ClassName: TokenInterceptor
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        String resultString = "";

        //请求头中携带token
        String token = request.getHeader("Authorization");


        TokenResult tokenResult = null;
        try {
            //解析token
            tokenResult = JwtUtils.parseToken(token);
        } catch (SignatureVerificationException e) {
            //签名错误
            resultString = "token sign error";
            flag = false;
        } catch (TokenExpiredException e) {
            resultString = "token time out";
            flag = false;
        } catch (AlgorithmMismatchException e) {
            resultString = "token AlgorithmMismatchException";
            flag = false;
        } catch (Exception e) {
            resultString = "token invalid";
            flag = false;
        }

        if (tokenResult == null) {
            resultString = "token invalid";
        } else {
            //拼接key
            String phone = tokenResult.getPhone();
            String identity = tokenResult.getIdentity();
            //从redis中获取token
            //比较传入的token和redis中的token是否一致
            String tokenKey = RedisPrefixUtils.generatorToken(phone, identity, TokenConstants.ACCESS_TOKEN_TYPE);
            String tokenRedis = redisTemplate.opsForValue().get(tokenKey);
            if (tokenRedis == null ||!tokenRedis.equals(token)) {
                resultString = "token invalid";
                flag = false;
            }else {
                if (!token.trim().equals(tokenRedis.trim())){
                    resultString = "token invalid";
                    flag = false;
                }
            }
        }

        if (!flag) {
            PrintWriter out = response.getWriter();
            out.print(JSONObject.fromObject(ResponseResult.fail(resultString)).toString());
        }

        return flag;
    }
}
