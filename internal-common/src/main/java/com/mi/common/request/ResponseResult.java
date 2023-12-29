package com.mi.common.request;

import com.mi.common.constant.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ClassName: ResponseResult
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@Data
@Accessors(chain = true)
public class ResponseResult<T> {

    private int code;
    private String message;
    private T data;

    /**
     * 成功响应的方法
     * @param data 返回的数据
     * @return
     * @param <T>
     */
    public static <T> ResponseResult success(T data){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getMessage()).setData(data);
    }

    public static <T> ResponseResult success(){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getMessage());
    }

    /**
     * 失败：自定义失败 错误码和提示信息
     * @param code
     * @param message
     * @return
     * @param <T>
     */
    public static <T> ResponseResult fail(int code, String message){
        return new ResponseResult().setCode(code).setMessage(message);
    }

    /**
     * 失败：自定义失败 错误码 提示信息 具体错误
     * @param code
     * @param message
     * @param data
     * @return
     * @param <T>
     */
    public static <T> ResponseResult fail(int code,String message,String data){
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }

    /**
     * 失败：统一的失败
     * @param data
     * @return
     * @param <T>
     */
    public static <T> ResponseResult fail(T data){
        return new ResponseResult().setCode(CommonStatusEnum.FAILURE.getCode()).setMessage(CommonStatusEnum.FAILURE.getMessage()).setData(data);
    }

}
