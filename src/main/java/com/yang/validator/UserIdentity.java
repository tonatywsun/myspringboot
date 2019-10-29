package com.yang.validator;

import com.yang.constant.SexEnum;

import javax.validation.Payload;

/**
 * @Description: 自定义校验注解，被校验字段value为yangyang（此处yangyang为默认值）
 * @Author: tona.sun
 * @Date: 2019/10/21 10:32
 */
//@Constraint(validatedBy = {OnlySexCanOperationValidator.class})
//@Documented
//@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
public @interface UserIdentity {
    String message() default "名称必须为{name}";

    /**
     * 自定义注解中声明的方法返回类型必须是以下其一，不然编译会出错，
     * 1. A primitive type
     * 2. String
     * 3. Class
     * 4. An enum type
     * 5. An annotation type
     * 6. An array type 类型为以上任一类型的数组
     */
    SexEnum sex() default SexEnum.MAN;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
