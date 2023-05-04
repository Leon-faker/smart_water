package com.smart.water.exception;

import com.smart.water.enums.ResultCodeEnum;

public class TokenException extends RuntimeException{
    private int code;
    private String msg;

    public TokenException(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public TokenException(String msg){
        this.code = 500;
        this.msg = msg;
    }

    public TokenException(ResultCodeEnum resultCodeEnum){
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
