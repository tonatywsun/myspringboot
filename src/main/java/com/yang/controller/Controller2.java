package com.yang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangyang
 * @date 2019/8/26 14:21
 */
@Slf4j
@RestController
public class Controller2 {
    @RequestMapping("/controller2/test1")
    public String test1() {
        return "test1";
    }

    @RequestMapping("/controller2/{id}")
    public Long test2(@PathVariable Long id) {
        log.info("Controller2 test2");
        return id;
    }

    /**
     * @param id
     * @description : 优先级大于test2，不管是传123还是abc
     * @author : tona.sun
     * @date : 2019/10/28 13:49
     */
    @GetMapping("/controller2/{id}")
    public Map test3(@PathVariable String id) {
        log.info("Controller2 test3");
        Map<String, Date> map = new HashMap<>();
        //返回一个当前时间用于测试jason中时间格式，jscksonConf中定义了返回时间的格式
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        map.put(id, date);
        return map;
    }
}

