package co.edu.sena.project_yaml.domain;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AllowedCombinationValidator.class)
public @interface AllowedCombination {
    String message() default "Combinación de campos no permitida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
