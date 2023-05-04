package com.smart.water.enums;

import lombok.Data;

/**
 * description:  错误信息枚举类规定：编写时按照模块分类，每个模块写到一起，便于修改和维护返回状态根据Http状态码定义来 <br>
 * @version: 1.0
 * @date: 2023/03/30
 * @author: douglea
 */
public enum ResultCodeEnum {
    //基础
    SUCCESS(200,"成功"),
    FAIL(500,"系统错误"),

    //公共模块
    UNAUTHORIZED(401,"未认证"),
    FORBIDDEN(401,"未授权"),
    ILLEGAL_VALUE(404,"参数非法"),
    OPERATION_FAILED(404,"操作失败"),


    //业务模块
    USER_NO_EXIST(1000,"用户不存在"),
    //token
    TOKEN_EEOR(2000,"token错误") ;

    ResultCodeEnum(int value, String message){
        this.value = value;
        this.message = message;
    }

    private int value;
    private String message;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
