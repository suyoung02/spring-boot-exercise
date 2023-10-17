package com.example.exercise1.Validation.SetValidation;

import java.util.Arrays;
import java.util.Set;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SetValidator implements ConstraintValidator<ValidSet, String> {
    private Set<String> validValues;

    @Override
    public void initialize(ValidSet constraintAnnotation) {
        validValues = Set.of(constraintAnnotation.allowedValues());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Allow null values if needed
        }
        return Arrays.stream(value.split(","))
                .allMatch(validValues::contains);
    }
}
