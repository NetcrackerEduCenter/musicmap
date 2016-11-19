package com.akvone.dao;

import com.akvone.entity.User;
import java.util.Set;

/**
 * Created by Kirill on 10.11.2016.
 */

public interface UserDAO {

    boolean add(User user);

    void update(User user);

    User findById(Long id);

    void delete(User user);

    Set<User> findAll();
}
