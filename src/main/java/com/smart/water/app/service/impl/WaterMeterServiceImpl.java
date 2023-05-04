package com.smart.water.app.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.water.api.controller.dto.WaterMeterDto;
import com.smart.water.app.service.WaterMeterService;
import com.smart.water.app.service.converter.WaterMeterConverter;
import com.smart.water.app.service.vo.WaterMeterVo;
import com.smart.water.exception.BusinessException;
import com.smart.water.infra.entity.WaterMeter;
import com.smart.water.infra.mapper.WaterMeterMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  水表服务
 * </p>
 *
 * @author DougLea
 * @since 2023-03-27
 */
@Service
@Slf4j
public class WaterMeterServiceImpl extends ServiceImpl<WaterMeterMapper, WaterMeter> implements WaterMeterService {
    private WaterMeterConverter waterMeterConverter = WaterMeterConverter.INSTANCE;
    @Override
    public WaterMeterVo save(WaterMeterDto waterMeterDto) {
        log.info("保存或更新:{}", JSONObject.toJSON(waterMeterDto));
        WaterMeterDto.SaveOrUpdate saveOrUpdate = (WaterMeterDto.SaveOrUpdate) waterMeterDto;
        if(isExistNo(saveOrUpdate.getWaterMeter())){
            throw new BusinessException("水表编号已存在");
        }
        WaterMeter waterMeter = waterMeterConverter.fromEntity(saveOrUpdate.getWaterMeter());
        if(saveOrUpdate.getOpt().equals(0)){
            save(waterMeter);
        }else {
            updateById(waterMeter);
        }
        return waterMeterConverter.entityFromVo(waterMeter);
    }

    @Override
    public WaterMeterVo getWaterMeterById(int id) {
        WaterMeter waterMeter = getById(id);
        return waterMeterConverter.entityFromVo(waterMeter);
    }

    @Override
    public List<?> list(String no,Integer regionId) {
        QueryWrapper<WaterMeter> queryWrapper = new QueryWrapper<>();
        if(!Objects.isNull(regionId)){
            queryWrapper.eq("region_id",regionId);
        }
        if(!StringUtils.isEmpty(no)){
            queryWrapper.like("no",no);
        }
        return waterMeterConverter.fromVo(list(queryWrapper));
    }

    //private

    /**
     * 检查水表编号是否重复,true 存在，false 不存在。
     * @param waterMeter
     * @return
     */
    private boolean isExistNo(WaterMeterDto.WaterMeterAdd waterMeter){
        QueryWrapper queryWrapper = new QueryWrapper<WaterMeter>();
        queryWrapper.eq("no",waterMeter.getNo());
        if(!Objects.isNull(waterMeter.getId())) {
            queryWrapper.ne("id", waterMeter.getId());
        }
        return getOne(queryWrapper) != null;
    }
}
