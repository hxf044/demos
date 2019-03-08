package com.hxf.controller.utils;

/**
 * http状态返回码，所有返回码在这里定义
 * @author peanut   angerpeanut@gmail.com
 * @since 1.0
 */
public enum ResponseStatus {

    OK(200, "成功"),
    ;

    private final int status;

    private final String msg;


    ResponseStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int status() {
        return this.status;
    }

    public String msg() {
        return msg;
    }

}
