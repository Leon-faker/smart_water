package com.smart.water.exception;

import com.smart.water.enums.ResultCodeEnum;

public class BusinessException extends RuntimeException{
    private int code;
    private String msg;

    public BusinessException(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(String msg){
        this.code = 500;
        this.msg = msg;
    }

    public BusinessException(ResultCodeEnum resultCodeEnum){
        this.code = resultCodeEnum.getValue();
        this.msg = resultCodeEnum.getMessage();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
