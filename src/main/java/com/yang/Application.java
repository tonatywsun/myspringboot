package com.yang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/*@ComponentScan("controller")
@EnableAutoConfiguration*/
//这个注解也可以动，默认扫当前包
//@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        String s ="https://static.maxxipoint.com/static/luckydraw/index.html?activityId=";
        for(int i=270;i<298;i++){
            System.out.println(s+i);
        }
        ConcurrentHashMap  a = new ConcurrentHashMap();
        a.put("a","a");
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(a);
        /*try {
            SpringApplication.run(Application.class);
        } catch (Exception e) {
            return;
        }*/
    }

}
