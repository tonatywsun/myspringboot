package com.yang.jacksonconf;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.yang.entry.Student;

import java.io.IOException;

/**
 * @Description: 将student json转为student对象
 * @Author: tona.sun
 * @Date: 2019/10/29 11:45
 */
public class StudentDeserializer extends JsonDeserializer<Student> {
    @Override
    public Student deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Integer sno = node.get("s_no").asInt();
        Student s = new Student();
        s.setSNo(sno.longValue());
        return s;
    }
}
