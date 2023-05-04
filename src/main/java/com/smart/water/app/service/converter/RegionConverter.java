package com.smart.water.app.service.converter;

import com.smart.water.app.service.vo.RegionVo;
import com.smart.water.infra.entity.Region;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author douglea
 * @Email ch.douglea.@gmai.com
 * @Date 2023/03/30 17:28
 * @Version 0.1
 **/
@Mapper
public interface RegionConverter {
    RegionConverter INSTANCE = Mappers.getMapper(RegionConverter.class);

    @Mappings({
            @Mapping(source = "updateOperator",target = "updateOperator"),
            @Mapping(source = "createTime",target = "createTime")
    })
    List<RegionVo> fromVo(List<Region> list);
}
