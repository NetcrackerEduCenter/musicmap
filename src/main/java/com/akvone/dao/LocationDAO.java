package com.akvone.dao;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.entity.Location;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


//@javax.transaction.Transactional
@Repository
public class LocationDAO extends HibernateDaoSupport implements ILocationDAO {

    @Transactional
    public boolean add(Location location) {
        if (getHibernateTemplate().find("select * from Location location where location.name = " + location.getName()).isEmpty()) {
            getHibernateTemplate().save(location);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void update(Location location) {
        getHibernateTemplate().update(location);
    }

    @Transactional(readOnly = true)
    public Location findById(Long id) {
        return getHibernateTemplate().get(Location.class, id);
    }

    @Transactional
    public void delete(Location location) {
        getHibernateTemplate().delete(location);
    }

    @Transactional(readOnly = true)
    public Set<Location> findAll() {
        return new HashSet(getHibernateTemplate().find("FROM com.akvone.entity.Location"));
    }
}
