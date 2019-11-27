package com.dyb.demo.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author dyb
 * @date 2019-11-27
 */
public class GlobalException extends RuntimeException {

    @Getter
    @Setter
    private String msg;

    public GlobalException(String message) {
        this.msg = message;
    }
}
