package com.yang.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/11/01 14:43
 */
@Configuration
@ConfigurationProperties(prefix = "redis")
@Data
@ToString
public class TestYml {
    Integer prot;
}
