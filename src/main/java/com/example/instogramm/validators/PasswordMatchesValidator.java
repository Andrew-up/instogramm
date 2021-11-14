package com.example.instogramm.validators;

import com.example.instogramm.annotations.PasswordMatches;
import com.example.instogramm.payload.request.SignupRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches,Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {}

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        SignupRequest signupRequest = (SignupRequest) o;
        return signupRequest.getPassword().equals(signupRequest.getConfirmPassword());
    }
}
