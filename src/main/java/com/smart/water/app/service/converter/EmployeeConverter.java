package com.smart.water.app.service.converter;

import com.smart.water.api.controller.dto.WaterMeterDto;
import com.smart.water.app.service.vo.EmployeeVo;
import com.smart.water.app.service.vo.WaterMeterVo;
import com.smart.water.infra.entity.Employee;
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
public interface EmployeeConverter {
    EmployeeConverter INSTANCE = Mappers.getMapper(EmployeeConverter.class);

    EmployeeVo.EmployeeLogin EntityToVo(Employee employee);
}
