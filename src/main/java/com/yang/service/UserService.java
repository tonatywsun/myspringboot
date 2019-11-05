package com.yang.service;

import com.yang.base.PageResult;
import com.yang.model.User;
import com.yang.vo.RestResponseVO;

import java.util.List;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/29 18:11
 */
public interface UserService {
    List<User> getAllUser();

    RestResponseVO<PageResult<User>> getAllUserForRestTemp();
}
