package com.example.annotation;

import com.example.annotation.annoclass.FlagValidatorClass;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {

    //flag的有效值,多个用 , 分隔
    String values();

    String message() default "flag 不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}

