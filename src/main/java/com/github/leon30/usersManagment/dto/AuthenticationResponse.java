package com.github.leon30.usersManagment.dto;

import com.github.leon30.usersManagment.security.Token;
import io.jsonwebtoken.JwtBuilder;

import java.util.Date;

public class AuthenticationResponse extends Token {

    public AuthenticationResponse(String token, Date exp) {
        super(token, exp);
    }
}
