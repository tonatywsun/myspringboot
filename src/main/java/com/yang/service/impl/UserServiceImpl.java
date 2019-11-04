package com.yang.service.impl;

import com.yang.mapper.UserMapper;
import com.yang.model.User;
import com.yang.service.UserService;
import com.yang.vo.BusinessParameters;
import com.yang.vo.TestYml;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/29 18:12
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BusinessParameters businessParameters;
    @Autowired
    private TestYml testYml;

    @Override
    public List<User> getAllUser() {
        log.info("businessParameters :{}", businessParameters);
        return userMapper.selectAll();
    }
}
