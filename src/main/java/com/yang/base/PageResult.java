package com.yang.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 分页返回数据
 * @Author: tona.sun
 * @Date: 2019/10/28 14:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 8085883156894729748L;
    /**
     * 数据总条数
     */
    private long total;
    /**
     * 数据集合
     */
    private List<T> result;

    public static <T> PageResult<T> of(long total, List<T> list) {
        PageResult<T> rs = new PageResult<T>();
        rs.total = total;
        rs.result = list;
        return rs;
    }
}
