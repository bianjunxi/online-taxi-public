package com.mi.common.constant;

import lombok.Data;

/**
 * ClassName: CommonStatusEnum
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
public enum CommonStatusEnum {

    /**
     * 成功
     */
    SUCCESS(1, "成功"),
    /**
     * 失败
     */
    FAILURE(0, "失败"),

    /**
     * 验证码错误提示,1000-1099
     */
    VERIFICATION_CODE_ERROR(1099, "验证码错误"),

    /**
     * token类提示,1100-1199
     */
    TOKEN_ERROR(1100, "token错误"),

    /**
     * 用户提示:1200-1299
     */
    USER_NOT_EXISTS(1200,"当前用户不存在"),

    /**
     * 计价规则:1300-1399
     */
    PRICE_RULE_EMPTY(1300,"计价规则不存在"),

    /**
     * 地图服务:1400-1499
     */
    MAP_DISTRICT_ERROR(1400,"请求地图错误"),

    ;

    private int code;

    private String message;

    CommonStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
