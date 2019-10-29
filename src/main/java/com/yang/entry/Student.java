package com.yang.entry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @Description: 学生实体类
 * @Author: tona.sun
 * @Date: 2019/10/18 15:58
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Student {
    //当校验上下文为Add.class的时候，＠Null生效,id 需为空才能校验通过；
    //当校验上下文为Update.class的时候，＠NotNull生效，id 不能为空;
    @Null(groups = {add.class})
    @NotNull(groups = {Student.Update.class})
    private Integer id;

    @NotNull
    private Long sNo;

    private String name;

    @Max(value = 140)
    private int age;

    @Email
    private String email;

    //定义一个类，更新时校验纽
    public interface Update {
    }

    //定义另一个类，添加时校验纽
    public interface add {
    }
}
