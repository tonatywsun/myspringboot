package com.yang.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description: TODO
 * @Author: tona.sun
 * @Date: 2019/10/21 10:31
 */
public class OnlyManCanOperationValidator implements ConstraintValidator<OnlyManCanOperation, String> {
    Yang yang;
    String name;

    @Override
    public void initialize(Yang constraintAnnotation) {
        this.yang = constraintAnnotation;
        name = yang.name();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.equals(name);
    }
}
