package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/17 17:59
 */
@Controller
public class Controller3 {

    @RequestMapping("/controller34/a.html")
    public String test1() {
        return "/a.jpg";
    }
}
