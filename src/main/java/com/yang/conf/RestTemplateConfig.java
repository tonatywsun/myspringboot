package com.yang.conf;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : tona.sun
 * @description : 使用redis相关配置
 * @date : 2019/11/6 19:13
 */

@Configuration
public class RestTemplateConfig {
    /**
     * @description : 创建一个RestTemplate放到spring容器中
     * @author : tona.sun
     * @date : 2019/11/4 19:21
     */
    @Bean
    public RestTemplate customRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonMessageConverter.setObjectMapper(objectMapper());
        messageConverters.add(jsonMessageConverter);
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }

    public ObjectMapper objectMapper() {
        ObjectMapper jackson2ObjectMapper = new ObjectMapper();
        jackson2ObjectMapper.configure(SerializationFeature.INDENT_OUTPUT, true)
                //包括null字段
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
                .registerModule(new ParameterNamesModule()).registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
        jackson2ObjectMapper.setPropertyNamingStrategy(new PropertyNamingStrategy.SnakeCaseStrategy());
        return jackson2ObjectMapper;
    }
}
