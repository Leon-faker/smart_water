package com.smart.water.infra.utils;

import com.smart.water.enums.ResultCodeEnum;

public class ResultUtil {
    private static final Result SUCCESS = new Result(ResultCodeEnum.SUCCESS);
    private static final Result FAIL = new Result(ResultCodeEnum.FAIL);

    public static Result success(){
        return SUCCESS;
    }

    public static Result success(ResultCodeEnum resultCodeEnum){
        return new Result(resultCodeEnum);
    }

    public static <T> Result success(T data){
        return new Result<T>(ResultCodeEnum.SUCCESS,data);
    }

    public static Result success(int code,String msg,String data){
        return new Result(code,msg,data);
    }

    public static Result fail(){
        return FAIL;
    }

    public static Result fail(ResultCodeEnum resultCodeEnum){
        return new Result(resultCodeEnum);
    }

    public static <T> Result fail(T data){
        return new Result<T>(ResultCodeEnum.FAIL,data);
    }

    public static <T> Result fail(int code,String msg,T data){
        return new Result(code,msg,data);
    }
}
