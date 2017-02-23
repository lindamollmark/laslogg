package com.laslogg.persistens.dao;

import com.laslogg.persistens.entity.UserEntity;

public interface UserDao {

    public void save(UserEntity user);

    public UserEntity getUser(String username);

   public boolean isValidUser(String username, String password);
}
