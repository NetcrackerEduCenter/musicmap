package com.akvone.service.impl;

import com.akvone.dao.UserDAO;
import com.akvone.entity.User;
import com.akvone.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User add(Long vkId, float x, float y) {
        User user;
        if (userDAO.exists(vkId)){
            user = userDAO.getByVkId(vkId);
        } else {
            user = new User();
            user.setVkId(vkId);
        }
        user.setX(x);
        user.setY(y);
        userDAO.save(user);
        return userDAO.getByVkId(vkId);
    }
}
