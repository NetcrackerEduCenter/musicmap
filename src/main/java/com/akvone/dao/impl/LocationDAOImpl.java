package com.akvone.dao.impl;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.entity.Location;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.akvone.dao.*;

@Repository
public class LocationDAOImpl implements LocationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Location getById(long id) {
        Location location;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria locationCriteria = session.createCriteria(Location.class);
            locationCriteria.add(Restrictions.eq("id", id));
            location = (Location) locationCriteria.uniqueResult();
        } catch (HibernateException ex) {
            return null;
        } finally {
            if (session != null)
                session.close();
        }
        return location;
    }

    @Override
    public Location getByName(String name) {
        Location location;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria locationCriteria = session.createCriteria(Location.class);
            locationCriteria.add(Restrictions.eq("name", name));
            location = (Location) locationCriteria.uniqueResult();
        } catch (HibernateException ex) {
            return null;
        } finally {
            if (session != null)
                session.close();
        }
        return location;
    }
}
