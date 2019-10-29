package com.yang.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pagehelper.PageInfo;
import com.yang.base.PageResult;
import com.yang.constant.BizStatus;
import com.yang.exception.BizException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/28 14:08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponseVO<T> {

    private static final long serialVersionUID = 1610092835821782334L;

    private Integer code;
    private String message = "";
    private T result;
    private List<ErrorDTO> errors;

    @JsonIgnore
    public boolean isSuccess() {
        return BizStatus.OK.code.equals(this.code);
    }

    public RestResponseVO(BizStatus bs) {
        this.code = bs.code;
        this.message = bs.message;
    }

    public RestResponseVO(T result, BizStatus bizStatus) {
        this.code = bizStatus.code;
        this.message = bizStatus.message;
        this.result = result;
    }

    public RestResponseVO(BizStatus bs, String message) {
        this.code = bs.code;
        this.message = message;
    }

    public RestResponseVO(BizException e) {
        this.code = e.getErrorCode();
        this.message = e.getMessage();
    }

    public RestResponseVO(Throwable e) {
        this.code = BizStatus.SYSTEM_ERROR.code;
        this.message = e.toString();
    }

    public static <T> RestResponseVO<T> success(T result) {
        return new RestResponseVO<T>(result, BizStatus.OK);
    }

    public static RestResponseVO<Void> success() {
        return new RestResponseVO<Void>(BizStatus.OK);
    }

    public static <T> RestResponseVO<T> fail(BizException bizException) {
        return new RestResponseVO<T>(bizException);
    }

    public static <T> RestResponseVO<PageResult<T>> page(PageInfo<T> page) {
        RestResponseVO<PageResult<T>> restResponseVO = new RestResponseVO<PageResult<T>>();
        PageResult<T> result = PageResult.of((int) page.getTotal(), page.getList());
        restResponseVO.setResult(result);
        restResponseVO.setCode(BizStatus.OK.code);
        return restResponseVO;
    }

    public static <T> RestResponseVO<List<T>> success(List<T> list) {
        RestResponseVO<List<T>> restResponseVO = new RestResponseVO<List<T>>();
        restResponseVO.setResult(list);
        restResponseVO.setCode(BizStatus.OK.code);
        return restResponseVO;
    }
}
