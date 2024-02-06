package com.mi.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ClassName: PassengerUser
 * Description: 用户信息实体类
 *
 * @author Jay
 * @version v1.0
 */
@Data
public class PassengerUser {

    private Long id;

    private String passengerPhone;

    private String passengerName;

    private byte passengerGender;

    private byte state;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private String profilePhoto;

}
