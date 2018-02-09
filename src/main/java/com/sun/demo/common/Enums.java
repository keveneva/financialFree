package com.sun.demo.common;

/**
 * Created by me on 2018/1/8.
 */
public enum Enums {
    SUNCESS(0,"成功"),
    ERROR(1,"失败"),
    SYSTEM_EXCETION(-1,"系统异常"),

    ;

    private Integer code;

    private String msg;

    Enums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
