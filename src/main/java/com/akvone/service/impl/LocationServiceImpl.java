package com.akvone.service.impl;

import com.akvone.dao.LocationDAO;
import com.akvone.entity.Location;
import com.akvone.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDAO locationDAO;

    @Override
    public Location getById(Long id){
        return locationDAO.getById(id);
    }
}
