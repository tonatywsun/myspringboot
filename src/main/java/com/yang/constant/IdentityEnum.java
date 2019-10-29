package com.yang.constant;

/**
 * @Description: 会员身份枚举类
 * @Author: tona.sun
 * @Date: 2019/10/28 12:41
 */
public enum IdentityEnum {
    GENERAL(1),
    VIP(2);
    int code;

    IdentityEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
