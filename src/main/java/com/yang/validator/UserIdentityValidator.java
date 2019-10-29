package com.yang.validator;

import com.yang.constant.SexEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/21 10:31
 */
public class OnlySexCanOperationValidator implements ConstraintValidator<OnlySexCanOperation, SexEnum> {
    OnlySexCanOperation onlySexCanOperation;
    SexEnum sex;

    @Override
    public void initialize(OnlySexCanOperation constraintAnnotation) {
        this.onlySexCanOperation = constraintAnnotation;
        sex = onlySexCanOperation.sex();
    }

    @Override
    public boolean isValid(SexEnum value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value == sex;
    }
}
