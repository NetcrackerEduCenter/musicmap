package com.akvone.dao;

import com.akvone.entity.User;

/**
 * Created by Kirill on 10.11.2016.
 */

public interface IUserDAO {

    boolean add(User user);

    void update(User user);

    User findById(Long id);

    void delete(User user);

}
