package com.yang.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 配置拦截器
 * @Author: tona.sun
 * @Date: 2019/10/21 10:45
 */
@Slf4j
@Component
public class MvcConfigurer implements WebMvcConfigurer {
    @Autowired
    HandlerInterceptor handlerInterceptor;

    /**
     * @param registry
     * @description : 装配一个拦截器，检查会话，URL 以**开头的都使用此拦截器,项目启动是就已经装配
     * @author : tona.sun
     * @date : 2019/10/21 10:48
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("MvcConfigurer addInterceptors");
        registry.addInterceptor(handlerInterceptor).addPathPatterns("/**");
    }


    /**
     * @param registry
     * @description : 跨域设置
     * @author : tona.sun
     * @date : 2019/10/21 11:28
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //此方法为允许所有跨域，更精密的筛选使用其他方法
        registry.addMapping("/**");
        log.info("MvcConfigurer addCorsMappings");
    }


    /**
     * @param registry
     * @description : 将HTTP请求映射到Controller方法的参数上后， Spring会自动进行类型转化。对于日期类
     * 型的参数，Spring 默认并没有配置如何将字符串转为日期类型。为了支持可按照指定格式转为日期类型，
     * 添加一个DateFormatter类
     * @author : tona.sun
     * @date : 2019/10/21 11:31
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
        log.info("MvcConfigurer addFormatters");
    }

    //URI到视图的映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }
}
