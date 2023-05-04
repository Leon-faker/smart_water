package com.smart.water;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.smart.water.infra.mapper")
@SpringBootApplication
public class SmartWaterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartWaterApplication.class, args);
    }

}
