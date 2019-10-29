package com.yang.validator;

import com.yang.constant.IdentityEnum;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 自定义校验注解，被校验字段identity必须为传入值
 * @Author: tona.sun
 * @Date: 2019/10/21 10:32
 */
@Constraint(validatedBy = {UserIdentityValidator.class})
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserIdentity {
    String message() default "身份必须为{IdentityEnum}";

    /**
     * 自定义注解中声明的方法返回类型必须是以下其一，不然编译会出错，
     * 1. A primitive type
     * 2. String
     * 3. Class
     * 4. An enum type
     * 5. An annotation type
     * 6. An array type 类型为以上任一类型的数组
     */
    IdentityEnum identity() default IdentityEnum.GENERAL;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
