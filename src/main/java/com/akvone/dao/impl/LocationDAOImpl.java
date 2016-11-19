package com.akvone.dao.impl;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.akvone.dao.*;
import java.util.HashSet;
import java.util.Set;

@Repository
public class LocationDAOImpl implements LocationDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public boolean add(Location location) {
        if (hibernateTemplate.find("from Location location where location.name = " + location.getName()).isEmpty()) {
            hibernateTemplate.save(location);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void update(Location location) {
        hibernateTemplate.update(location);
    }

    @Transactional(readOnly = true)
    public Location findById(Long id) {
        return hibernateTemplate.get(Location.class, id);
    }

    @Transactional
    public void delete(Location location) {
        hibernateTemplate.delete(location);
    }

    @Transactional(readOnly = true)
    public Set<Location> findAll() {
        return new HashSet(hibernateTemplate.find("FROM Location"));
    }
}
