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
    FAILURE(0, "失败")

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
