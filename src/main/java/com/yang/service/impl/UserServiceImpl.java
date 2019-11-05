package com.yang.service.impl;

import com.yang.base.PageResult;
import com.yang.mapper.UserMapper;
import com.yang.model.User;
import com.yang.service.UserService;
import com.yang.vo.Biz;
import com.yang.vo.BusinessParameters;
import com.yang.vo.RestResponseVO;
import com.yang.vo.TestYml;
import com.yang.vo.YmlConfTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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
    @Autowired
    private YmlConfTest ymlConfTest;
    @Autowired
    private Biz Biz;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<User> getAllUser() {
        log.info("businessParameters :{}", businessParameters);
        return userMapper.selectAll();
    }

    @Override
    public RestResponseVO<PageResult<User>> getAllUserForRestTemp() {
        ResponseEntity<RestResponseVO<PageResult<User>>> exchange = restTemplate.exchange("http://127.0.0.1:8088/user/getAllUser.json", HttpMethod.GET, null, new ParameterizedTypeReference<RestResponseVO<PageResult<User>>>() {
        });
        RestResponseVO<PageResult<User>> body = exchange.getBody();
        return body;
    }

}
