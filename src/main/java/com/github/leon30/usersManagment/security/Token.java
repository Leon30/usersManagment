package com.github.leon30.usersManagment.security;

import io.jsonwebtoken.JwtBuilder;

import java.util.Date;

public class Token {

    public String token;
    public Date expires_in;

    public Token(String token, Date exp) {
        this.token = token;
        this.expires_in = exp;
    }
}
