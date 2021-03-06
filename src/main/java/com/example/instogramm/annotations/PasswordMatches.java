package com.example.instogramm.annotations;

import com.example.instogramm.validators.PasswordMatchesValidator;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {

    String message()default  " Password don't email";

    Class<?>[] groups() default {};

    Class<? extends Payload> [] payload() default {};

}
