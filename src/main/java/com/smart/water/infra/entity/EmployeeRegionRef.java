package com.smart.water.infra.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 员工区域映射
 * @author DougLea
 * @since 2023-03-27
 */
@Data
public class EmployeeRegionRef extends BasicAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    //员工ID
    private Integer employeeId;

    //区域ID
    private Integer regionId;

    //名称
    private String name;

}
