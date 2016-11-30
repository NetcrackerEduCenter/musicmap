package com.akvone.dao.impl;

import com.akvone.entity.Location;
import com.akvone.dao.LocationDAO;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LocationDAOImpl implements LocationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Location getById(Long id) {
        Location location;
        try {
            Criteria locationCriteria = sessionFactory.getCurrentSession().createCriteria(Location.class);
            locationCriteria.add(Restrictions.eq("id", id));
            location = (Location) locationCriteria.list().get(0);
        } catch (HibernateException ex) {
            return null;
        }
        return location;
    }
}
