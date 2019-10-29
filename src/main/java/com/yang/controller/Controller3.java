package com.yang.controller;

import com.yang.entry.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/17 17:59
 */
@Controller
@Slf4j
public class Controller3 {
    //ModelAttribute通常作用在Controller的某个方法上，此方法会在url映射方法之前首先被调用，并将方法结果作为Model的属性，然后再调用对应的Controller处理方法。
    //只对当前controller中方法有效
    @ModelAttribute
    public void modelAttribute(/*@PathVariable Long id,*/ Model model) {
        log.info("Controller3 ModelAttribute");
        model.addAttribute("key", "value");
    }

    /**
     * @param id
     * @description : 返回静态文件
     * @author : tona.sun
     * @date : 2019/10/28 14:00
     */
    @RequestMapping(value = "/controller3/{id}/a.html")
    public String test1(@PathVariable Long id) {
        return "/a.jpg";
    }

    /**
     * @description : 加ResponseBody之后返回静态文件
     * @author : tona.sun
     * @date : 2019/10/28 14:00
     */
    @ResponseBody
    @RequestMapping(path = "/controller3/{id}/b.html")
    public String test2() {
        return "/a.jpg";
    }

    //@Validated执行一次校验,校验默认组；value = {Student.add.class}则只校验add组
    @ResponseBody
    @RequestMapping(path = "/controller3/3.json")
    public Student test3(@Validated/*(value = {Student.add.class})*/ Student student) {
        return student;
    }

    /**
     * @description : 发生异常跳到/error（在errorController中）
     * @author : tona.sun
     * @date : 2019/10/28 14:23
     */
    @ResponseBody
    @RequestMapping(path = "/controller3/4.json")
    public void test4() {
        log.info("Controller3 test4");
        int i = 1 / 0;
    }
}
