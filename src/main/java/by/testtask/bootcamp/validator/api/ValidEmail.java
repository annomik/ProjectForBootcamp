package by.testtask.bootcamp.validator.api;

import by.testtask.bootcamp.validator.ValidEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= ValidEmailValidator.class)
public @interface ValidEmail {
    String message() default "Email not validated";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
