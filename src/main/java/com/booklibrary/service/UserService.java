package com.booklibrary.service;

import com.booklibrary.dao.UserMapper;
import com.booklibrary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public boolean addUser(User user) {
        int i = 0;
        try {
            i = userMapper.insertUser(user);
        } catch (Exception e) {
            return false;
        }

        return i > 0;
    }

    public User findUserByLogin(User user) {
        return userMapper.selectUserByLogin(user);
    }

    public boolean modifUser(User user) {
        int i = 0;
        try {
            i = userMapper.updateUser(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
