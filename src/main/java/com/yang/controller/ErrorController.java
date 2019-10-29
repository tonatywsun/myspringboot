package com.yang.controller;

import com.yang.exception.BizException;
import com.yang.vo.RestResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Description: 错误处理controller
 * @Author: tona.sun
 * @Date: 2019/10/21 11:41
 */
@RestController
@Slf4j
public class ErrorController extends AbstractErrorController {

    public ErrorController() {
        super(new DefaultErrorAttributes());
    }

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping("/error")
    public RestResponseVO<BizException> getErrorPath(HttpServletRequest request, HttpServletResponse response) {
        //处理异常
        log.info("getErrorPath");
        return RestResponseVO.fail(new BizException("系统异常"));
    }
}
