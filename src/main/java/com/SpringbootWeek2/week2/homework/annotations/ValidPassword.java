package com.SpringbootWeek2.week2.homework.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPasswordValidator.class)
@Documented
public @interface ValidPassword {
    String message() default "Password must contain 1 uppercase, 1 lowercase, 1 special char, min 10 chars";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
