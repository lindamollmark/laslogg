package com.laslogg.persistens.entity;

import com.laslogg.core.model.User;

import javax.persistence.Entity;


@Entity
public class UserEntity {

    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser() {
        return new User(id, username, password);
    }

    public UserEntity fromModel(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        return this;
    }
}
