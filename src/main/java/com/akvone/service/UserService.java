package com.akvone.service;

import com.akvone.dao.IUserDAO;
import com.akvone.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kirill on 10.11.2016.
 */
@Service
public class UserService implements IUserService{
    @Autowired
    private IUserDAO userDAO;

    @Override
    public boolean addUser(User user) {
        userDAO.addUser(user);
        return true;
    }
}
