package com.akvone.service.impl;

import com.akvone.dao.LocationDAO;
import com.akvone.entity.Location;
import com.akvone.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nikitafedorovv on 26/11/2016.
 */

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDAO locationDAO;

    @Override
    public Location getById(long id){
        return locationDAO.getById(id);
    }

    @Override
    public Location getByName(String name){
        return locationDAO.getByName(name);
    }

}
