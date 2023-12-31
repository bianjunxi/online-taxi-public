package com.mi.common.dto;

import lombok.Data;

/**
 * ClassName: TokenResult
 * Description: 解析token返回结果
 *
 * @author Jay
 * @version v1.0
 */
@Data
public class TokenResult {
    private String phone;
    private String identity;
}
