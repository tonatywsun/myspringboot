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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.redis.core.StringRedisTemplate;
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
    @Autowired
    private StringRedisTemplate redisClient;

    @Override
    public List<User> getAllUser() {
        redisClient.opsForValue().set("y", "v");
        log.info("businessParameters :{}", businessParameters);
        return userMapper.selectAll();
    }

    /**
     * @description : 参数int id 放入redis中key是user::1
     * 参数User user 放入redis中key是 "user::User(id=1, uNo=null, uIdentity=null, uStatus=null, uName=yy, uSex=null, uAge=null, uBirthday=null, updateDatetime=null, createDatetime=null)"
     * 因为@Cacheable是使用AOP代理实现的,通过创建内部类来代理缓存方法.
     * 这样就会导致一个问题，类内部的方法调用类内部的缓存方法不会走代理，就不能正常创建缓存，所以每次都需要去调用数据库。
     * 因为@Cacheable由AOP实现，所以，如果该方法被其它注解切入，当缓存命中的时候，则其它注解不能正常切入并执行,@Before也不行，
     * 当缓存没有命中的时候，其它注解可以正常工作
     * @author : tona.sun
     * @date : 2019/11/6 11:40
     */
    @Override
   @Cacheable("user")
   // @CacheEvict(cacheNames = "user",allEntries = true)
    public User getOneUser(User user) {
        log.info("businessParameters :{}", businessParameters);
        return userMapper.selectByPrimaryKey(user.getId());
    }

    @Override
    public RestResponseVO<PageResult<User>> getAllUserForRestTemp() {
        ResponseEntity<RestResponseVO<PageResult<User>>> exchange = restTemplate.exchange("http://127.0.0.1:8088/user/getAllUser.json", HttpMethod.GET, null, new ParameterizedTypeReference<RestResponseVO<PageResult<User>>>() {
        });
        RestResponseVO<PageResult<User>> body = exchange.getBody();
        return body;
    }

}
