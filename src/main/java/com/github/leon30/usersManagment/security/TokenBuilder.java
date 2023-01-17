package com.github.leon30.usersManagment.security;

import java.util.Date;

public class TokenBuilder {

    public static Token createToken(String token, Date expiresIn){
        //Decidir que tipo de token es
        return new TokenJWT(token, expiresIn);
    }
}
