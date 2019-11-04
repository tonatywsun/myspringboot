package com.yang.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/11/01 13:44
 */
@ToString
@Data
@Component
public class BusinessParameters {
    @Value("${testKey:123}")
    private String testKey;
    @Value("${yangTestKey:123}")
    private String yangTestKey;
}
