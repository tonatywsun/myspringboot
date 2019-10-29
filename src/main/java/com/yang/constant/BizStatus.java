package com.yang.constant;

/**
 * @Description: 状态码
 * @Author: tona.sun
 * @Date: 2019/10/28 14:10
 */
public enum BizStatus {
    OK(200, "成功"),
    CREATED(201, "Created"),
    BAD_REQUEST(400, "Bad Request"),
    SYSTEM_ERROR(999, "system error"),
    ;

    BizStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code;
    public String message;


}
