package com.mi.passenger.request;

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
