package com.smart.water.app.service.vo;

import lombok.Data;

/**
 * @Author douglea
 * @Email ch.douglea.@gmai.com
 * @Date 2023/03/31 10:17
 * @Version 0.1
 **/
@Data
public class WaterMeterVo extends BasicVo{
    @Data
    public static class WaterMeter extends WaterMeterVo{
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
}
