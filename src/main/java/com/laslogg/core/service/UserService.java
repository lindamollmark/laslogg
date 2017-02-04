package com.laslogg.core.service;

import com.laslogg.persistens.dao.UserDao;
import com.laslogg.persistens.entity.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by Linda on 2017-02-04.
 */
@Service
public class UserService {

    ApplicationContext context =
            new ClassPathXmlApplicationContext("Spring-Module.xml");

    private UserDao dao= (UserDao) context.getBean("userDao");


    public boolean isValidUser(String username, String password) {

        return true;
    }

    public boolean addUser(String username, String password) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        dao.save(user);
 return true;
    }
}
