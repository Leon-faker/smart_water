package com.smart.water.app.service.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author douglea
 * @Email ch.douglea.@gmai.com
 * @Date 2023/03/30 17:17
 * @Version 0.1
 **/
@Data
public class BasicVo {
    //更新时间
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    //更新人
    private String updateOperator;
    //创建时间
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    //创建人
    private String createOperator;
}
