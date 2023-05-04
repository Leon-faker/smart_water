package com.smart.water.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.water.api.controller.dto.EmployeeDto;
import com.smart.water.app.service.vo.EmployeeVo;
import com.smart.water.infra.entity.Employee;
import com.smart.water.infra.utils.Result;

/**
 * Employee Service
 * @author DougLea
 * @since 2023-03-27
 */
public interface EmployeeService extends IService<Employee> {

    /**
     * 员工登录
     * @param employeeDto
     * @return token
     */
    EmployeeVo login(EmployeeDto employeeDto);
}
