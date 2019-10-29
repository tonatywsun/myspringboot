package com.yang.base;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/28 14:14
 */
@EqualsAndHashCode(callSuper = false)
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 8085883156894729748L;

    private long total;

    private List<T> result;

    public static <T> PageResult<T> of(long total, List<T> list) {
        PageResult<T> rs = new PageResult<T>();
        rs.total = total;
        rs.result = list;
        return rs;
    }
}
