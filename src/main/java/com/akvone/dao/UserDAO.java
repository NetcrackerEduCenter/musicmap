package com.akvone.dao;

import com.akvone.entity.User;

public interface UserDAO {

    void save(User user);

    boolean exists(Long vkId);

    User getByVkId(Long vkId);

}
