package com.akvone.service;

import com.akvone.dao.IStartInfoDAO;
import com.akvone.dao.IUserDAO;
import com.akvone.entity.StartInfo;
import com.akvone.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Kirill on 10.11.2016.
 */
public class UserService implements IUserService{
    @Autowired
    private IUserDAO userDAO;

    @Override
    public boolean addUser(User user) {
        return false;
    }
}
