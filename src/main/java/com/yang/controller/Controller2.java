package com.yang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyang
 * @date 2019/8/26 14:21
 */
@RestController
public class Controller2 {
    @RequestMapping("/controller2/test1")
    public String test1() {
        return "test1";
    }

    @RequestMapping("/controller2/{id}")
    public Long test2(@PathVariable Long id) {
        return id;
    }

    @GetMapping("/controller2/{id}")
    public String test3(@PathVariable String id) {
        return id;
    }
}

