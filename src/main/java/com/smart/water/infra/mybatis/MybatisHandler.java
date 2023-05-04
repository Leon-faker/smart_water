package com.smart.water.infra.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.smart.water.conifg.SecurityUser;
import com.smart.water.conifg.UserContext;
import com.smart.water.infra.utils.LocalDateTimeUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * Mybaits-plus 统一插入公共属性
 * @Author douglea
 * @Email ch.douglea.@gmai.com
 * @Date 2023/04/06 14:08
 * @Version 0.1
 **/
@Component
public class MybatisHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        SecurityUser user = UserContext.currentUser();
        this.setFieldValByName("createTime", LocalDateTimeUtil.getCurrentTime(),metaObject);
        this.setFieldValByName("createOperator",user.getName(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        SecurityUser user = UserContext.currentUser();
        this.setFieldValByName("updateTime", LocalDateTimeUtil.getCurrentTime(),metaObject);
        this.setFieldValByName("updateOperator",user.getName(),metaObject);
    }
}
