package com.smart.water.api.controller.dto;

import lombok.Data;

/**
 * @Author douglea
 * @Email ch.douglea.@gmai.com
 * @Date 2023/03/30 16:31
 * @Version 0.1
 **/
@Data
public class WaterMeterDto {

    @Data
    public static class SaveOrUpdate extends WaterMeterDto{
        private Integer opt;//0 创建，1 更新
        private WaterMeterAdd waterMeter;
    }

    @Data
    public static class WaterMeterAdd{
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
