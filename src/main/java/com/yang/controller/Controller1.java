package com.yang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springboot测试controller
 *
 * @author yangyang
 * @date 2019/8/26 0:57
 */

@RestController
//EnableAutoConfiguration注解 开启自动装配 默认只扫当前包
//@EnableAutoConfiguration
//加上此注解可设置扫包
//@ComponentScan("controller")
public class Controller1 {

    //@ResponseBody 表示此方法返回的是文本而不是视图名称
    @RequestMapping("/controller1/test1")
    public String test1() {
        return "test1";
    }

    /**
     * EnableAutoConfiguration注解 开启自动装配
     *
     * @param args
     * @return void
     * @author yangyang
     * @date 2019/8/26 1:28
     */
    /*public static void main(String[] args) {
        //程序入口 默认地址http://127.0.0.1:8080
        SpringApplication.run(Controller1.class);
    }*/
}
