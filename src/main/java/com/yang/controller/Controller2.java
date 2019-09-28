package com.yang.controller;

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
}

