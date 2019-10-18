package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@ComponentScan("controller")
@EnableAutoConfiguration*/
//这个注解也可以动，默认扫当前包
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        try {
            SpringApplication.run(Application.class);
        } catch (Exception e) {
            return;
        }
    }

}
