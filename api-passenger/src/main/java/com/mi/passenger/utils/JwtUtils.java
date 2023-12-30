package com.mi.passenger.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: JWTUtils
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
public class JwtUtils {

    //盐
    private static final String SECRET = "wojiaobjx";

    //生成token
    public static String generateToken(Map<String,String> map) {
        //token过期时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        Date date = calendar.getTime();

        JWTCreator.Builder builder = JWT.create();
        //整合map
        map.forEach((key,value)->{
            builder.withClaim(key,value);
        });

        //整合过期时间
        builder.withExpiresAt(date);

        //生成token
        String sign = builder.sign(Algorithm.HMAC256(SECRET));

        return sign;
    }

    //解析token

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name","x");
        map.put("age","18");
        System.out.println(generateToken(map));
    }

}
