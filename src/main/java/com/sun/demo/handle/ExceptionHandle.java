package com.sun.demo.handle;

import com.sun.demo.common.Result;
import com.sun.demo.exception.BusinessException;
import com.sun.demo.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tanyouwen
 * 系统全局的 统一异常处理
 */
@ControllerAdvice
public class ExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof BusinessException){
            BusinessException businessException = (BusinessException)e;
            return ResultUtils.error(businessException.getCode(),businessException.getMessage());
        }
        logger.error("系统异常{}",e);
        return ResultUtils.error(-1,"未知错误");
    }

}
