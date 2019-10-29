package com.yang.entry;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yang.jacksonconf.StudentDeserializer;
import com.yang.jacksonconf.StudentSerializer;
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
//使用StudentDeserializer将字符串解析为Student对象
//@JsonDeserialize(using = StudentDeserializer.class)
//使用StudentSerializer将Student对象解析为字符串
//@JsonSerialize(using = StudentSerializer.class)
public class Student {
    //当校验上下文为Add.class的时候，@Null生效,id 需为空才能校验通过；
    //当校验上下文为Update.class的时候，@NotNull生效，id不能为空;
    @Null(groups = {add.class})
    @NotNull(groups = {Student.Update.class})
    private Integer id;

    //当方法上加@JsonView(Student.add.class)则会返回含有@JsonView(Student.add.class)注解的不加JsonView的属性字段
    //不加JsonView的默认都返回
    @JsonView(add.class)
    @NotNull
    private Long sNo;

    @JsonView(add.class)
    private String name;

    @Max(value = 140)
    @JsonView(Update.class)
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
