package com.smart.water.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.water.app.service.RegionService;
import com.smart.water.app.service.converter.RegionConverter;
import com.smart.water.app.service.vo.RegionVo;
import com.smart.water.infra.entity.Region;
import com.smart.water.infra.mapper.RegionMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  区域服务
 * </p>
 *
 * @author DougLea
 * @since 2023-03-27
 */
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {
    private RegionConverter regionConverter = RegionConverter.INSTANCE;

    @Override
    public List<RegionVo> list(String name) {
        QueryWrapper<Region> regionQueryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(name)){
            regionQueryWrapper.like("name",name);
        }
        List<Region> regionList = list(regionQueryWrapper);
        return regionConverter.fromVo(regionList);
    }
}
