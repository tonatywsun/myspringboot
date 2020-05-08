package com.yang.mapper;

import com.yang.base.TkMapper;
import com.yang.model.Card;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2020/05/08 12:01
 */
@Mapper
@Component(value = "cardMapper")
public interface CardMapper extends TkMapper<Card> {
}
