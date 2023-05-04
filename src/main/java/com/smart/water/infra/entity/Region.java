package com.smart.water.infra.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 区域实体
 * @author DougLea
 * @since 2023-03-27
 */
@Data
public class Region extends BasicAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    //区域名称
    private String name;

    //所属营业所ID
    private Integer companyId;

    //当前区域户主数量
    private Integer userNum;

}
