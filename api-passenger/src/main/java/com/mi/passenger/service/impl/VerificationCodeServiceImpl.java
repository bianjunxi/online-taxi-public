package com.mi.passenger.service.impl;

import com.mi.passenger.service.VerificationCodeService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * ClassName: VerificationCodeServiceImpl
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    /**
     * 发送验证码
     *
     * @param passengerPhone 手机号
     * @return json
     */
    @Override
    public String generatorCode(String passengerPhone) {
        // 调用验证码的服务,获取验证码
        System.out.println("调用验证码的服务,获取验证码");

        // 存入redis
        System.out.println("存入redis");

        //返回值
        JSONObject result = new JSONObject();
        result.put("code",1);
        result.put("message","success");

        return result.toString();
    }
}
