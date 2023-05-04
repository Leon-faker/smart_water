package com.smart.water.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.water.app.service.vo.RegionVo;
import com.smart.water.infra.entity.Region;

import java.util.List;

/**
 * Region Service
 * @author DougLea
 * @since 2023-03-27
 */
public interface RegionService extends IService<Region> {

    /**
     * 查询水表列表
     * @param name 水表编号
     * @return
     */
    List<RegionVo> list(String name);
}
