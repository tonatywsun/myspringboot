package com.yang.service.impl;

import com.yang.mapper.MemberMapper;
import com.yang.model.Member;
import com.yang.service.MemberService;
import com.yang.vo.Biz;
import com.yang.vo.BusinessParameters;
import com.yang.vo.TestYml;
import com.yang.vo.YmlConfTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Description: MemberServiceImpl
 * @Author: tona.sun
 * @Date: 2019/10/29 18:12
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
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
    public List<Member> getAllUser() {
        //redisClient.opsForValue().set("y", "v");
        log.info("businessParameters :{}", businessParameters);
        //测试用 可以查出Member中的List<Card> cards;
        //实现为xml中的<collection property="cards" ofType="com.yang.model.Card" column="{member_id=id}" select="selectCardByMember"/>
        List<Member> members = memberMapper.selectAllMember();
        return memberMapper.selectAll();
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
    public Member getOneUser(Member member) {
        log.info("businessParameters :{}", businessParameters);
        return memberMapper.selectByPrimaryKey(member.getId());
    }

   /* @Autowired
    private DiscoveryClient client;

    @Override
    public RestResponseVO<PageResult<Member>> getAllUserForRestTemp() {
        List<ServiceInstance> instances = client.getInstances("local");
        ResponseEntity<RestResponseVO<PageResult<Member>>> exchange = restTemplate.exchange("http://127.0.0.1:8088/user/getAllUser.json", HttpMethod.GET, null, new ParameterizedTypeReference<RestResponseVO<PageResult<Member>>>() {
        });
        RestResponseVO<PageResult<Member>> body = exchange.getBody();
        return body;
    }*/

}
