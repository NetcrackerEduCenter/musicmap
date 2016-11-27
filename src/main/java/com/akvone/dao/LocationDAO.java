package com.akvone.dao;

import com.akvone.entity.Location;
import java.util.Set;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

public interface LocationDAO {

    Location getById(Long id);

    Location getByName(String name);

}
