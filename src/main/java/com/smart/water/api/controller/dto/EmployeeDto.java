package com.smart.water.api.controller.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    @Data
    public static class EmployeeLoginDto extends EmployeeDto{
        private String name;
        private String password;
    }
}
