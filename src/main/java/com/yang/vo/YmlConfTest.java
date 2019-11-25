package com.yang.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: apollo-client(jar包)版本1.1不支持读取yml，搞了一下午
 * @Author: tona.sun
 * @Date: 2019/11/04 13:46
 */
@Component
@ConfigurationProperties(prefix = "biz-param1")
@Data
@ToString
public class YmlConfTest {
    String yy;
    String yyy;
    String yyyy;
}
