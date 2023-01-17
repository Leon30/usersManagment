package com.github.leon30.usersManagment.security;

import java.util.Date;

public abstract class Token {

    String token;
    Date expires_in;

    public abstract String getToken();

    public abstract void setToken(String token);

    public abstract Date getExpires_in();

    public abstract void setExpires_in(Date expires_in);

}
