package com.yang.base;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description: TkMapper基类
 * @Author: tona.sun
 * @Date: 2019/10/29 16:55
 */
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
