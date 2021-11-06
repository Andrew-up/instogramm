package com.example.instogramm.security;

public class SecutiryConstants {

    public static final String SIGN_UP_URLS ="/api/auth/**";
    public static final String SECRET_KEY ="secret";
    public static final String TOKEN_PREFIX ="Bearer ";
    public static final String HEADER_STRING ="Authorization";
    public static final String CONTENT_TYPE ="Application/json";
    public static final long EXPIRATION_TIME = 900_000; //15 минут

}
