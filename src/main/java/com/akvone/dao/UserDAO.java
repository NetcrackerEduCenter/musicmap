package com.akvone.dao;

import com.akvone.entity.User;
import java.util.Set;

/**
 * Created by Kirill on 10.11.2016.
 */

public interface UserDAO {

    void save(User user);

    boolean exists(Long vkId);

    User getByVkId(Long vkId);

}
