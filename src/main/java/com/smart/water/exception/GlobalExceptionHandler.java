package com.smart.water.exception;

import com.smart.water.infra.utils.Result;
import com.smart.water.infra.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result globalException(BusinessException businessException, HttpServletResponse response){
        return ResultUtil.fail(businessException.getCode(),businessException.getMsg(),businessException);
    }
}
