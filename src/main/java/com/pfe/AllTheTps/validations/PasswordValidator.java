package com.pfe.AllTheTps.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
        @Override
        public void initialize(Password constraintAnnotation) {
        }
        @Override
        public boolean isValid(String password,
                ConstraintValidatorContext context) {
            if (password == null) {
                return false;
            }
            boolean hasUpperCase = false;
            boolean hasLowerCase = false;
            boolean hasDigit = false;
            boolean hasSpecialChar = false;
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) hasUpperCase = true;
                if (Character.isLowerCase(c)) hasLowerCase = true;
                if (Character.isDigit(c)) hasDigit = true;
                if (!Character.isLetterOrDigit(c)) hasSpecialChar =
                        true;
            }
            return hasUpperCase && hasLowerCase && hasDigit &&
                    hasSpecialChar && password.length() >= 8;
        }
    }




