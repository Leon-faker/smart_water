package com.smart.water.app.service.converter;

import com.smart.water.api.controller.dto.WaterMeterDto;
import com.smart.water.app.service.vo.RegionVo;
import com.smart.water.app.service.vo.WaterMeterVo;
import com.smart.water.infra.entity.Region;
import com.smart.water.infra.entity.WaterMeter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author douglea
 * @Email ch.douglea.@gmai.com
 * @Date 2023/03/30 17:28
 * @Version 0.1
 **/
@Mapper
public interface WaterMeterConverter {
    WaterMeterConverter INSTANCE = Mappers.getMapper(WaterMeterConverter.class);

    WaterMeter fromEntity(WaterMeterDto.WaterMeterAdd waterMeter);

    WaterMeterVo.WaterMeter entityFromVo(WaterMeter waterMeter);
    List<WaterMeterVo.WaterMeter> fromVo(List<WaterMeter> list);
}
