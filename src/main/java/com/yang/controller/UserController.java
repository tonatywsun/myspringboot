package com.yang.controller;

import com.yang.base.PageResult;
import com.yang.model.Member;
import com.yang.service.MemberService;
import com.yang.vo.RestResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: User表对应Controller
 * @Author: tona.sun
 * @Date: 2019/10/29 18:11
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "user api", tags = "UserController")
public class UserController {
    @Autowired
    private MemberService userService;


    @GetMapping("/getAllUser.json")
    @ApiOperation(value = "查询所有用户", responseReference = "RestResponseVO<PageResult<User>>", notes = "分页查询所有用户")
    public RestResponseVO<PageResult<Member>> getAllUser() {
        List<Member> allUser = userService.getAllUser();
        PageResult<Member> of = PageResult.of(CollectionUtils.isEmpty(allUser) ? 0 : allUser.size(), allUser);
        return RestResponseVO.success(of);
    }


    @GetMapping(value = "/getAllUserForRestTemp.json", produces = {"application/json;charset=UTF-8"})
    public RestResponseVO<PageResult<Member>> getAllUserForRestTemp() {
        Member user = new Member();
        user.setId(1L);
        userService.getOneUser(user);
        return null;//userService.getAllUserForRestTemp();
    }
}
