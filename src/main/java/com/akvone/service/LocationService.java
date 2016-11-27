package com.akvone.service;

import com.akvone.entity.Location;

/**
 * Created by nikitafedorovv on 26/11/2016.
 */

public interface LocationService {

    Location getById(Long id);

    Location getByName(String name);

}
