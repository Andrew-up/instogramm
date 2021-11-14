package com.example.instogramm.payload.request;

import com.example.instogramm.annotations.PasswordMatches;
import com.example.instogramm.annotations.ValidEmail;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
public class SignupRequest {

    @Email(message = "it should be email format")
    @NotBlank(message = "User email is request")
    @ValidEmail
    private String email;

    @NotEmpty(message = "Please enter your name")
    private String firstname;

    @NotEmpty(message = "Please enter your lastname")
    private String lastname;

    @NotEmpty(message = "Please enter your username")
    private String username;

    @NotEmpty(message = "Please enter your password")
    @Size(min = 5, max = 50)
    private String password;

    @NotEmpty(message = "Please enter your password again")
    private String confirmPassword;
}
