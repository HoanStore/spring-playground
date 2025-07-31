package com.hoan.springplayground.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotAdminValidator implements ConstraintValidator<NotAdmin, String> {
    @Override
    public void initialize(NotAdmin constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.equalsIgnoreCase("admin");
    }
}
