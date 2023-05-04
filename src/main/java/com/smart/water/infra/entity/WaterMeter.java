package com.smart.water.infra.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 水表实体
 * @author DougLea
 * @since 2023-03-27
 */
@Data
public class WaterMeter extends BasicAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;
    private String no;
    private Integer regionId;
    private String residentName;
    private String residentPhoneNumber;
    private Integer waterMeterTypeId;
    private String bore;
    private String imgUrl;
    private String longitude;
    private String latitude;
    private String address;

}
