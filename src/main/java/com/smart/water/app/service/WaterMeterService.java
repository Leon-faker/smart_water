package com.smart.water.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.water.api.controller.dto.WaterMeterDto;
import com.smart.water.app.service.vo.WaterMeterVo;
import com.smart.water.infra.entity.WaterMeter;

import java.util.List;

/**
 * WaterMeter Service
 * @author DougLea
 * @since 2023-03-27
 */
public interface WaterMeterService extends IService<WaterMeter> {

    /**
     * 保存水表信息
     * @param waterMeterDto
     * @return
     */
    WaterMeterVo save(WaterMeterDto waterMeterDto);

    /**
     * 根据水表id获取水表信息
     * @param id
     * @return
     */
    WaterMeterVo getWaterMeterById(int id);

    List<?> list(String no,Integer regionId);
}
