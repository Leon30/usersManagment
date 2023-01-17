package com.github.leon30.usersManagment.dto;

import java.util.Date;

public class AuthenticationResponse {

    private String token;
    private Date exp;
    public AuthenticationResponse(String token, Date exp) {
        this.token=token;
        this.exp = exp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }
}
