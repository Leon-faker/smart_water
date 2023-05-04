package com.smart.water.app.service.vo;

import lombok.Data;

@Data
public class EmployeeVo {
    @Data
    public static class Employee{
        private Integer id;
        private String name;
        //手机号
        private String phoneNumber;
        //头像
        private String headImg;
        //所属营业所ID
        private Integer companyId;
        //手册名
        private String handbook;
    }
    @Data
    public static class EmployeeLogin extends EmployeeVo{
        private String token;
        private Employee employee;
    }
}
