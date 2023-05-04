package com.smart.water.infra.utils;

import com.smart.water.enums.ResultCodeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int resultCode;
    private String message;
    private T data;

    public Result(){

    }

    public Result(int resultCode, String message,T data){
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
    }

    public Result(ResultCodeEnum resultCodeEnum){
        this.resultCode = resultCodeEnum.getValue();
        this.message = resultCodeEnum.getMessage();
    }

    public Result(ResultCodeEnum resultCodeEnum,T data){
        this.resultCode = resultCodeEnum.getValue();
        this.message = resultCodeEnum.getMessage();
        this.data = data;
    }

}

