package com.smart.water.conifg;

import lombok.Data;

/**
 * 使用者
 * @Author douglea
 * @Email ch.douglea.@gmai.com
 * @Date 2023/04/06 11:05
 * @Version 0.1
 **/
@Data
public class SecurityUser {
    private Integer id;
    private String name;

    private SecurityUser(){}

    public static SecurityUser getInstance(){
        return new SecurityUser();
    }

}
