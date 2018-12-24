package com.example.annotation;

import com.example.annotation.annoclass.FlagValidatorClass;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author weiwei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/12/2421:59
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {

    //flag 的有效值，多个，用 ， 分隔
    String values();

    String message() default "flag 不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}

