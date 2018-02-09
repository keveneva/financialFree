package com.sun.demo.common;

/**
 * Created by tanyouwen
 * 2018年1月8日10:25:50
 */
public class Result<T> {

    /**
     * 编码 0 正常 1 异常
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回结果
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
