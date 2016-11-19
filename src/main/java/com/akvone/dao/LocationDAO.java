package com.akvone.dao;

import com.akvone.entity.Location;
import java.util.Set;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

public interface LocationDAO {

    boolean add(Location location);

    void update(Location location);

    Location findById(Long id);

    void delete(Location location);

    Set<Location> findAll();
}
