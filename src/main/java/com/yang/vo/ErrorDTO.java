package com.yang.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/28 14:12
 */
@Data
public class ErrorDTO  implements Serializable {

    private static final long serialVersionUID = 2156087233580306009L;
    private String code;
    private String field;
    private String resource;

}
