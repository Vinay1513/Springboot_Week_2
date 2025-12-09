package com.SpringbootWeek2.week2.homework.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsPrimeValidator implements ConstraintValidator<IsPrime, Number> {

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        if (value == null) return true;

        long num = value.longValue();
        if (num <= 1) return false;

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


}