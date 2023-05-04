package com.smart.water.infra.utils;

import com.smart.water.infra.constant.LocalDateTimePattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTImeUtil 工具类
 * @Author douglea
 * @Email ch.douglea.@gmai.com
 * @Date 2023/04/06 13:44
 * @Version 0.1
 **/
public class LocalDateTimeUtil {

    /**
     * 获取当前系统时间
     * @return
     */
    public static LocalDateTime getCurrentTime(){
        return LocalDateTime.now();
    }

    /**
     * 返回指定格式的日期字符串
     * @param pattern
     * @return
     */
    public static String getCurrentTime(String pattern){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }
}
