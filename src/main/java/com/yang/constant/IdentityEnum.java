package com.yang.constant;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/28 12:41
 */
public enum SexEnum {
    MAN(1),
    WOMAN(2);
    int code;

    SexEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
