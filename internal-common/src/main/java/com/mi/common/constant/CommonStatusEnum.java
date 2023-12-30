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
    VERIFICATION_CODE_ERROR(1099, "验证码错误");

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
