package com.hxf.controller.utils;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2018/10/22.
 */
public class ResponseObject  implements Serializable {
    private static final long serialVersionUID = 2732127907851832345L;

    private int status;

    private String msg;

    private Object data;

    public ResponseObject(ResponseStatus status, Object data) {
        this.data = data;
        this.status = status.status();
        this.msg = status.msg();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }


    public static ResponseObject ok() {
        return new ResponseObject(ResponseStatus.OK, null);
    }

    public static ResponseObject ok(Object data) {
        return new ResponseObject(ResponseStatus.OK, data);
    }




}
