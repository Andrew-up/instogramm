package com.example.instogramm.payload.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginRequest {

    @NotNull(message = "Username cannon be empty")
    private String username;
    @NotNull(message = "Password cannon be empty")
    private String password;


}
