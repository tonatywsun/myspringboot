package com.yang.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: 用来测试apollo取值
 * @Author: tona.sun
 * @Date: 2019/11/04 15:35
 */
@Data
@Component
@ToString
public class Biz {
    @Value("${tets.tt}")
    private String aa;
}
