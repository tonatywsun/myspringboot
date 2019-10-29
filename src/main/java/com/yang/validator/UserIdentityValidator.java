package com.yang.validator;

import com.yang.constant.IdentityEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description: 自定义校验
 * @Author: tona.sun
 * @Date: 2019/10/21 10:31
 */
public class UserIdentityValidator implements ConstraintValidator<UserIdentity, IdentityEnum> {
    UserIdentity userIdentity;
    IdentityEnum identity;

    @Override
    public void initialize(UserIdentity constraintAnnotation) {
        this.userIdentity = constraintAnnotation;
        identity = userIdentity.identity();
    }

    @Override
    public boolean isValid(IdentityEnum value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value == identity;
    }
}
