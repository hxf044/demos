package com.hxf.test.web.util;

/**
 * http状态返回码，所有返回码在这里定义
 * @author peanut   angerpeanut@gmail.com
 * @since 1.0
 */
public enum ResponseStatus {

    OK(200, "成功"),
    USER_PASS_NULL(500,"用户名或密码为空"),
    USER_NULL(501,"用户名或密码不对"),
    NOT_NULL_FOR_ID(300, "id不能为空"),
    ID_HAS_EXIST(301, "id已经存在"),
    PARAM_ERROR(302, "参数错误"),
    TIMESTAMP_EXPIRED(303, "validateTimestamp已过期"),
    VALUE_ERROR(304, "validateValue错误"),
    NAME_HAS_EXIST(305, "数据重复"),
    UNAUTHORIZED(401, "没有授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源没有找到"),
    UNKNOWN_ERROR(405, "未知错误请稍后尝试"),
    NOT_SECURITY_KEY(460, "key不存在"),
    INTERNAL_SERVER_ERROR(500, "服务器错误"),
    NOT_NULL_FOR_PARAM(600, "参数为空"),
    /**
     * 状态码1XXX为global模块
     */
    CALL_PLAN_EXIST(3005, "该客户已有拨打计划"),

    /**
     * 状态码2XXX为user模块
     */
    LOGIN_FAIL(2000, "登陆失败"),
    USER_NOT_EXIST(2001, "用户不存在"),
    /**
     * 状态码2XXX为order模块
     */
    ORDERS_AWAIT_ALREADY(4000,"订单已支付"),
    ORDERS_CANCELLED(4001,"订单已取消"),
    ORDERS_AWAIT_PAYMENT(4002,"未支付"),
    /**
     * 状态码2XXX为client模块
     */
    CLIENT_NULL(5000,"该店铺没有客户信息"),
    CLIENT_XLSX_NUM_NULL(5001,"文件格式与模板不匹配"),
    /**
     * 状态码2XXX为client模块
     */
    STORES_NULL(5000,"店铺不存在"),
    CALL_PLAN_NAME_HAS_EXIST(6005, "计划名称重复"),
    IMPORT_PHONE_NAME_HAS_EXIST(7006, "列表名称重复"),

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
