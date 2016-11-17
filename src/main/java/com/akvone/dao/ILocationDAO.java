package com.akvone.dao;

import com.akvone.entity.Location;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */
public interface ILocationDAO {

    boolean add(Location location);

    void update(Location location);

    Location findById(Long id);

    void delete(Location location);
}
