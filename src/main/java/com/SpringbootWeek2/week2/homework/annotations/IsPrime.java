package com.SpringbootWeek2.week2.homework.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsPrimeValidator.class)
@Documented
public @interface IsPrime {
    String message() default "Must be a prime number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
