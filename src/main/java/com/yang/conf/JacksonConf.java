package com.yang.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @Description: ObjectMapper是用Swift编写的框架，可让您轻松地将模型对象（类和结构）与JSON相互转换
 * https://github.com/tristanhimmelman/ObjectMapper
 * @Author: tona.sun
 * @Date: 2019/10/28 12:01
 */
@Slf4j
@Configuration
public class JacksonConf {
    @Bean
    public ObjectMapper getObjectMapper() {
        log.info("JacksonConf getObjectMapper");
        ObjectMapper objectMapper = new ObjectMapper();
        //自定义返回对象时间格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //其他设置待学习
        //objectMapper.set...
        return objectMapper;
    }
}
