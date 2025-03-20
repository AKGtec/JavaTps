package com.pfe.AllTheTps.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
    String message() default
            "{NotValid.password}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
