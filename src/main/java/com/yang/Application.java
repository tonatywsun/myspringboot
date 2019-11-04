package com.yang;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/*@ComponentScan("controller")
@EnableAutoConfiguration*/
//这个注解也可以动，默认扫当前包
@SpringBootApplication
@MapperScan(basePackages = "com.yang.mapper")
@EnableApolloConfig
public class Application {
    public static void main(String[] args) {
        try {
            SpringApplication.run(Application.class);
        } catch (Exception e) {
            return;
        }
    }

}
