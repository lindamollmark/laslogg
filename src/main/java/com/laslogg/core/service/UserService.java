package com.laslogg.core.service;

import com.laslogg.core.model.User;
import com.laslogg.persistens.dao.UserDao;
import com.laslogg.persistens.entity.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    ApplicationContext context =
            new ClassPathXmlApplicationContext("Spring-Module.xml");

    private UserDao dao = (UserDao) context.getBean("userDao");


    public boolean isValidUser(String username, String password) {
        UserEntity user = dao.getUser(username);
        return dao.isValidUser(username, password);
    }

    public boolean addUser(String username, String password) {
        if(isValidUser(username, password)){
            return false;
        }
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        dao.save(user);
        return true;
    }

    public User getUser(String username, String password) {
        UserEntity ue = dao.getUser(username);
        return ue.toUser();
    }
}
