package com.yang.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description: 自定义拦截器
 * @Author: tona.sun
 * @Date: 2019/10/21 10:50
 */
@Slf4j
@Component
public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object name = request.getAttribute("name");
        log.info("MyHandlerInterceptor preHandle name:{}", name);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("MyHandlerInterceptor postHandle");
    }

    //Controller方法处理完毕后，调用此方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //页面渲染完毕后调用此方法，通常用来清除某些资源，类似Java语法的finally
        log.info("MyHandlerInterceptor afterCompletion");
    }
}
