package com.smart.water.api.controller;

import com.smart.water.app.service.RegionService;
import com.smart.water.app.service.converter.RegionConverter;
import com.smart.water.infra.utils.Result;
import com.smart.water.infra.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

/**
 * @Author douglea
 * @Email ch.douglea.@gmai.com
 * @Date 2023/03/30 17:32
 * @Version 0.1
 **/
@RestController
@RequestMapping("/region")
public class RegionController {

    private RegionService regionService;

    public RegionController(RegionService regionService){
        this.regionService = regionService;
    }

    @GetMapping("/list")
    public Result list(@RequestParam("name") String name){
        return ResultUtil.success(regionService.list(name));
    }
}
