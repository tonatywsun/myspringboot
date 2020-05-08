package com.yang.mapper;

import com.yang.base.TkMapper;
import com.yang.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/29 16:57
 */
@Mapper
@Component(value = "memberMapper")
public interface MemberMapper extends TkMapper<Member> {

    List<Member> selectAllMember();
}
