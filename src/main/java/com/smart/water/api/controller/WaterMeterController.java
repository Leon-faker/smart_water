package com.smart.water.api.controller;

import com.smart.water.api.controller.dto.WaterMeterDto;
import com.smart.water.app.service.WaterMeterService;
import com.smart.water.infra.utils.Result;
import com.smart.water.infra.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author douglea
 * @Email ch.douglea.@gmai.com
 * @Date 2023/03/31 10:29
 * @Version 0.1
 **/
@RestController
@RequestMapping("/water")
public class WaterMeterController {

    @Resource
    private WaterMeterService waterMeterService;

    @PostMapping("/saveOrUpdate")
    public Result save(@RequestBody WaterMeterDto.SaveOrUpdate saveOrUpdate){
        return ResultUtil.success(waterMeterService.save(saveOrUpdate));
    }

    @GetMapping("/getWaterInfo")
    public Result getOne(@RequestParam Integer id){
        return ResultUtil.success(waterMeterService.getWaterMeterById(id));
    }

    @GetMapping("/list")
    public Result list(@RequestParam String no,
                       @RequestParam Integer regionId){
        return ResultUtil.success(waterMeterService.list(no,regionId));
    }
}
