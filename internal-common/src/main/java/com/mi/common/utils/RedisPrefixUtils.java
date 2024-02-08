package com.mi.common.utils;

/**
 * ClassName: RedisPrefixUtils
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
public class RedisPrefixUtils {

    /**
     * 乘客验证码前缀
     */
    public static final String VERIFICATION_CODE_PREFIX = "verification_code_";
    /**
     * token存储的前缀
     */
    public static final String TOKEN_PREFIX = "token_";

    /**
     * 根据手机号,生成key
     * @param passengerPhone 手机号
     * @return
     */
    public static String generatorKeyByPhone(String passengerPhone,String identity){
        return VERIFICATION_CODE_PREFIX + identity +"_" + passengerPhone;
    }

    /**
     * 根据手机号和前缀和标识,生成token
     * @param passengerPhone
     * @param identity
     * @return
     */
    public static String generatorTokenKey(String passengerPhone,String identity,String tokenType){
        return TOKEN_PREFIX + passengerPhone + "_" + identity +"_" + tokenType;
    }

}
