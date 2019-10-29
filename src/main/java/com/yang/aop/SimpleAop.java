package com.yang.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: aop
 * @Author: tona.sun
 * @Date: 2019/10/17 15:41
 */
@Configuration
@Aspect
@Slf4j
public class SimpleAop {
    /**
     * @description : 对使用RestController注解的类进行aop
     * @author : tona.sun
     * @date : 2019/10/28 12:06
     */
    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object simpleAop(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("SimpleAop simpleAop before:{}",joinPoint.getArgs());
        Object proceed = joinPoint.proceed();
        log.info("SimpleAop  simpleAop");
        return proceed;
    }
}
