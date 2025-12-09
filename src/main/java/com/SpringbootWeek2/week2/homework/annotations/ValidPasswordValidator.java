package com.SpringbootWeek2.week2.homework.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPasswordValidator implements ConstraintValidator<ValidPassword, String> {

    private static final String UPPERCASE_PATTERN = "(?=.*[A-Z])";
    private static final String LOWERCASE_PATTERN = "(?=.*[a-z])";
    private static final String SPECIAL_PATTERN = "(?=.*[!@#$%^&*()_+-=\\[\\]{};':\"\\\\|,.<>/?])";
    private static final String MIN_LENGTH = ".{10,}";

    private static final String PASSWORD_PATTERN =
            "^(?=" + UPPERCASE_PATTERN + ")(?=" + LOWERCASE_PATTERN + ")(?=" + SPECIAL_PATTERN + ")" + MIN_LENGTH + "$";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        return password.matches(PASSWORD_PATTERN);
    }
}