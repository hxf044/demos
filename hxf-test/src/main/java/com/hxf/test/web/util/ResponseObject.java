package com.hxf.test.web.util;



import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author peanut   angerpeanut@gmail.com
 * @since 1.0
 */
public class ResponseObject implements Serializable{

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

    public static ResponseObject list(List list) {
        return new ResponseObject(ResponseStatus.OK, new ResponseInnerListObject(list));
    }

    public static ResponseObject failure(ResponseStatus status) {
        return new ResponseObject(status, null);
    }

    public static ResponseObject failure(ResponseStatus status, Object data) {
        return new ResponseObject(status, data);
    }

    public static <X> ResponseObject wrapOrNotFound(Optional<X> data) {
        return data.map(response -> ResponseObject.ok(response))
                .orElse(ResponseObject.failure(ResponseStatus.NOT_FOUND));
    }


    public static <X> ResponseObject wrapOrNull(Optional<X> data,ResponseStatus status) {
        return data.map(response -> ResponseObject.ok(response))
                .orElse(ResponseObject.failure(status));
    }






}
