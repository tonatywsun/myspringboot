package com.yang.service;

import com.yang.base.PageResult;
import com.yang.model.User;
import com.yang.vo.RestResponseVO;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @Description: UserService
 * @Author: tona.sun
 * @Date: 2019/10/29 18:11
 */
public interface UserService {
    List<User> getAllUser();

    @Cacheable("user")
    User getOneUser(User user);

    RestResponseVO<PageResult<User>> getAllUserForRestTemp();
}
