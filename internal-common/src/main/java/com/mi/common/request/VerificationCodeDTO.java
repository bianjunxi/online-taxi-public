package com.mi.common.request;

import lombok.Data;

/**
 * ClassName: VerificationCodeDTO
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@Data
public class VerificationCodeDTO {

    private String passengerPhone;
    private String verificationCode;

}
