package com.yang.mapper;

import com.yang.base.TkMapper;
import com.yang.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/29 16:57
 */
@Mapper
@Component(value = "userMapper")
public interface UserMapper extends TkMapper<User> {
}
