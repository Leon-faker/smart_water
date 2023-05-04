package com.smart.water.api.controller;

import com.smart.water.api.controller.dto.EmployeeDto;
import com.smart.water.app.service.EmployeeService;
import com.smart.water.app.service.vo.EmployeeVo;
import com.smart.water.infra.filter.TokenFilter;
import com.smart.water.infra.utils.Result;
import com.smart.water.infra.utils.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/employe")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/login")
    public Result login(@RequestBody EmployeeDto.EmployeeLoginDto employeeDto, HttpServletResponse response){
        EmployeeVo.EmployeeLogin employeeLogin = (EmployeeVo.EmployeeLogin) employeeService.login(employeeDto);
        response.addHeader(TokenFilter.AUTHORIZATION,employeeLogin.getToken());
        return ResultUtil.success(employeeLogin);
    }
}
