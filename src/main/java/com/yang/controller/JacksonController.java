package com.yang.controller;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.entry.Student;
import com.yang.mapper.UserMapper;
import com.yang.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/28 18:33
 */
@RestController
@Slf4j
@RequestMapping("/jackson")
public class JacksonController {
    @Autowired
    ObjectMapper mapper;

    /**
     * @description :read Tree 方法可以接受一个字符串或者字节数组、文件、InputStream 等，
     * 返回JsonNode作为根节点,你可以像操作XML DOM 那样操作遍历JsonNode 以获取数据。
     * @author : tona.sun
     * @date : 2019/10/28 18:39
     */
    @GetMapping("/readtree.json")
    public String readtree() throws JsonProcessingException, IOException {
        String json = "{\"name\":\"yangyang\",\"id\":10}";
        JsonNode node = mapper.readTree(json);
        String name = node.get("name").asText();
        int id = node.get("id").asInt();
        return " name : " + name + ", id:" + id;
    }

    /**
     * @description : string转对象
     * @author : tona.sun
     * @date : 2019/10/28 18:50
     */
    @GetMapping("/databind.json")
    public String databind() throws JsonProcessingException, IOException {
        String json = "{\"name\":\"yangyang\",\"id\":10}";
        Student user = mapper.readValue(json, Student.class);
        return " name : " + user.getName() + ", id:" + user.getId();
    }

    /**
     * @description : 对象转json
     * @author : tona.sun
     * @date : 2019/10/28 18:51
     */
    @GetMapping("/serialization.json")
    public String serialization() throws IOException {
        Student student = new Student();
        student.setAge(14);
        student.setEmail("1234@qq.com");
        return mapper.writeValueAsString(student);
    }

    //@JsonAnySetter,标记在某个方法上，此方法接受Key、Value两个参数，用于JackSon在反序列化过程中，未找到的对应属性都调用此方法。
    @JsonAnySetter
    //@JsonAnyGetter，此注解标注在一个返回Map的方法上，Jackson会取出Map中的每一个值进行序列化。
    @JsonAnyGetter
    @GetMapping("/jasonAnnotation.json")
    public Map jasonAnnotation(@RequestParam(name = "k", required = false) String k, @RequestParam(name = "v", required = false) Integer v) {
        Map map = new HashMap();
        map.put(k, v);
        return map;
    }

    //这样返回值只会返回含有@JsonView(Student.add.class)注解的属性字段不加JsonView的默认都显示
    @JsonView(Student.add.class)
    @GetMapping("/student.json")
    public Student student() {
        Student s = new Student();
        s.setSNo(1L);
        s.setName("aa");
        s.setId(2);
        s.setAge(22);
        return s;
    }
}
