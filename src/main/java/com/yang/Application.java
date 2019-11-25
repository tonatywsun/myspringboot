package com.yang;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*@ComponentScan("controller")
@EnableAutoConfiguration*/
//这个注解也可以动，默认扫当前包
@SpringBootApplication
//@MapperScan(basePackages = "com.yang.mapper")
@EnableApolloConfig
@EnableCaching
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args) {
        try {
            SpringApplication.run(Application.class);
        } catch (Exception e) {
            return;
        }
    }
}
