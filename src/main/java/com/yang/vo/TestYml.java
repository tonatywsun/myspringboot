package com.yang.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: apollo yml测试
 * @Author: tona.sun
 * @Date: 2019/11/01 14:43
 */
@Component
@ConfigurationProperties(prefix = "yangyang")
@Data
@ToString
public class TestYml {
    String testkey;
}
