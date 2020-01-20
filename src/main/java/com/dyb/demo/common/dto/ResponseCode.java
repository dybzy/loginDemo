package com.dyb.demo.common.dto;


import com.dyb.demo.common.enums.StatusEnums;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 验证码
 * @author dyb
 * @date 2019-11-27
 */
@Data
@AllArgsConstructor
public class ResponseCode {

    private Integer code;
    private String msg;
    private Object data;

    public ResponseCode(StatusEnums enums) {
        this.code = enums.getCode();
        this.msg = enums.getInfo();
    }

    public ResponseCode(StatusEnums enums, Object data) {
        this.code = enums.getCode();
        this.msg = enums.getInfo();
        this.data = data;
    }

    public ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseCode success() {
        return new ResponseCode(StatusEnums.SUCCESS);
    }

    public static ResponseCode success(Object data) {
        return new ResponseCode(StatusEnums.SUCCESS, data);
    }

    public static ResponseCode error() {
        return new ResponseCode(StatusEnums.SYSTEM_ERROR);
    }
}
