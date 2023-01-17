package com.github.leon30.usersManagment.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("users")
public abstract class User {

    @Id
    String id;
    long doc;
    String id_type;
    String telephone;
    String email;
    Date birthDate;

    public static User createUser(long doc, String id_type, String telephone, String email, Date birthDate){
        return new UserImp(doc,id_type,telephone,email,birthDate);
    }
}
