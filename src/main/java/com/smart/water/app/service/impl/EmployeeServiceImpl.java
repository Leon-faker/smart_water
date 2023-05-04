package com.smart.water.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.water.api.controller.dto.EmployeeDto;
import com.smart.water.app.service.EmployeeService;
import com.smart.water.app.service.converter.EmployeeConverter;
import com.smart.water.app.service.vo.EmployeeVo;
import com.smart.water.conifg.SecurityUser;
import com.smart.water.exception.BusinessException;
import com.smart.water.infra.entity.Employee;
import com.smart.water.infra.mapper.EmployeeMapper;
import com.smart.water.infra.utils.Jwt;
import com.smart.water.infra.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  员工服务
 * </p>
 *
 * @author DougLea
 * @since 2023-03-27
 */
@Slf4j
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    private EmployeeConverter employeeConverter = EmployeeConverter.INSTANCE;
    @Override
    public EmployeeVo login(EmployeeDto employeeDto) {
        EmployeeDto.EmployeeLoginDto employeeLoginDto = (EmployeeDto.EmployeeLoginDto) employeeDto;
        Employee employee = getOne(new QueryWrapper<Employee>().eq("name",employeeLoginDto.getName())
                .eq("password", MD5Util.md5(employeeLoginDto.getPassword())));
        if(employee == null){
            //用户不存在
            throw new BusinessException("用户不存在");
        }
        EmployeeVo.EmployeeLogin employeeLogin = employeeConverter.EntityToVo(employee);
        SecurityUser securityUser = SecurityUser.getInstance();
        securityUser.setId(employee.getId());
        securityUser.setName(employee.getName());
        employeeLogin.setToken(Jwt.createToken(securityUser));
        return employeeLogin;
    }
}
