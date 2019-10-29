package com.yang.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 自定义校验注解，被校验字段value为yangyang（此处yangyang为默认值）
 * @Author: tona.sun
 * @Date: 2019/10/21 10:32
 */
@Constraint(validatedBy = {MyValidator.class})
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OnlyManCanOperation {
    String message() default "名称必须为{name}";

    String name() default "yangyang";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
