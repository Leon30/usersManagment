package com.github.leon30.usersManagment.security;

import java.util.Date;

public class TokenJWT extends Token {

    public TokenJWT(String token, Date exp) {
        this.token = token;
        this.expires_in = exp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Date expires_in) {
        this.expires_in = expires_in;
    }

}
