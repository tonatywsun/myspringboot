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
    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object simpleAop(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("aop before");
        Object proceed = joinPoint.proceed();
        log.info("aop after");
        return proceed;
    }
}
