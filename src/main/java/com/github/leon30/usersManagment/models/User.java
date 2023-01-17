package com.github.leon30.usersManagment.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("users")
public class User {

    @Id
    private String id;
    private long doc;
    private String id_type;
    private String telephone;
    private String email;
    private Date birthDate;

    public User(long doc, String id_type, String telephone, String email, Date birthDate) {
        this.doc = doc;
        this.id_type = id_type;
        this.telephone = telephone;
        this.email = email;
        this.birthDate = birthDate;
    }

    public long getDoc() {
        return doc;
    }

    public void setDoc(long doc) {
        this.doc = doc;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
