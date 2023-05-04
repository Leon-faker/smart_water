package com.smart.water.infra.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 员工实体
 * @author DougLea
 * @since 2023-03-27
 */
@Data
public class Employee extends BasicAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    //员工名称
    private String name;

    //登录密码
    private String password;

    //手机号
    private String phoneNumber;

    //头像
    private String headImg;

    //所属营业所ID
    private Integer companyId;

    //手册名
    private String handbook;
}
