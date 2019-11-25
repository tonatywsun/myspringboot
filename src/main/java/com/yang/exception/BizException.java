package com.yang.exception;

import com.yang.constant.BizStatus;
import com.yang.vo.RestResponseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: 业务异常
 * @Author: tona.sun
 * @Date: 2019/10/28 14:13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 987422455044246688L;
    private Integer errorCode;
    private String message;

    public BizException(RestResponseVO<?> restResponseVO) {
        this.errorCode = restResponseVO.getCode();
        this.message = restResponseVO.getMessage();
    }

    public BizException(String message) {
        this.errorCode = BizStatus.SYSTEM_ERROR.code;
        this.message = message;
    }

    public BizException(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public BizException(Exception e) {
        super(e);
        this.errorCode = BizStatus.SYSTEM_ERROR.code;
        this.message = e.getMessage();
    }

    public BizException(RuntimeException e) {
        super(e);
        this.errorCode = BizStatus.SYSTEM_ERROR.code;
        this.message = e.getMessage();
    }

    public BizException(BizStatus bizStatus) {
        this.errorCode = bizStatus.code;
        this.message = bizStatus.message;
    }

    public BizException(BizStatus bizStatus, String message) {
        this.errorCode = bizStatus.code;
        this.message = message;
    }

}
