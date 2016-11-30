package com.akvone.dao;

import com.akvone.entity.Style;

public interface StyleDAO {

    Style getById(Long id);

    boolean exists(Long id);

}
