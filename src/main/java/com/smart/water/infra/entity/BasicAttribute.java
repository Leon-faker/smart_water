package com.smart.water.infra.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class BasicAttribute {
    //更新时间
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    //更新人
    @TableField(fill = FieldFill.UPDATE)
    private String updateOperator;
    //创建时间
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    //创建人
    @TableField(fill = FieldFill.INSERT)
    private String createOperator;
}
