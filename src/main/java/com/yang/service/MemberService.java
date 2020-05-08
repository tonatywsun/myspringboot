package com.yang.service;

import com.yang.model.Member;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @Description: MemberService
 * @Author: tona.sun
 * @Date: 2019/10/29 18:11
 */
public interface MemberService {
    List<Member> getAllUser();

    @Cacheable("member")
    Member getOneUser(Member member);

    //RestResponseVO<PageResult<Member>> getAllUserForRestTemp();
}
