package com.akvone.service;

import com.akvone.entity.Style;

/**
 * Created by nikitafedorovv on 26/11/2016.
 */

public interface StyleService {

    Style getById(Long id);

    Style getByName(String name);

}
