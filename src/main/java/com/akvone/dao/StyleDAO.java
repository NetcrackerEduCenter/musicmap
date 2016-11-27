package com.akvone.dao;

import com.akvone.entity.Style;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

public interface StyleDAO {

    Style getByName(String name);

    Style getById(Long id);

}
