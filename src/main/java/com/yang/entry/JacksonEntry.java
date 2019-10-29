package com.yang.entry;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/28 18:55
 */
//@JsonIgnoreProperties,忽略一组属性，作用于类上，比如@JsonIgnoreProperties({"id","photo"})
@JsonIgnoreProperties({"s2", "s3"})
//@JsonNaming,用于指定一个命名策略，作用于类或者属性上，类似@JsonProperty,但是自动命名。
//Jackson自带了多种命名策略，你可以实现自己的命名策略，比如输出的key由Java命名方式转为下面线命名方法userName 转化为user-name 。
@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
public class JacksonEntry {
    //@JsonProperty作用在属性上，用来为JSON Key指定一个别名。
    @JsonProperty("userName")
    private String s1;
    //JsonIgnore作用在属性上，用来忽略此属性
    @JsonIgnore
    private String password;

    private String s2;
    private String s3;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createDate;
}
