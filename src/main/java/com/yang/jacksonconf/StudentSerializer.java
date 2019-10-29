package com.yang.jacksonconf;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.yang.entry.Student;

import java.io.IOException;

/**
 * @Description: 将student对象转为json字符串
 * @Author: tona.sun
 * @Date: 2019/10/29 11:57
 */
public class StudentSerializer extends JsonSerializer<Student> {
    @Override
    public void serialize(Student student, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("s_no", student.getSNo());
        jsonGenerator.writeEndObject();
    }
}
