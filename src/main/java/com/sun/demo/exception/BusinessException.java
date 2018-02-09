package com.sun.demo.exception;

import com.sun.demo.common.Enums;

/**
 * Created by me on 2018/1/8.
 * 作为service捕获业务异常的类
 */
public class BusinessException extends RuntimeException{

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException(Enums enums){
        super(enums.getMsg());
        this.code = enums.getCode();
    }

}
