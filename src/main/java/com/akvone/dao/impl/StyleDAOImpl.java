package com.akvone.dao.impl;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.dao.*;
import com.akvone.entity.Style;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StyleDAOImpl implements StyleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Style getByName(String name) {
        Style style;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria styleCriteria = session.createCriteria(Style.class);
            styleCriteria.add(Restrictions.eq("name", name));
            style = (Style) styleCriteria.uniqueResult();
        } catch (HibernateException ex) {
            return null;
        } finally {
            if (session != null)
                session.close();
        }
        return style;
    }

    @Override
    public Style getById(long id) {
        Style style;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria styleCriteria = session.createCriteria(Style.class);
            styleCriteria.add(Restrictions.eq("id", id));
            style = (Style) styleCriteria.uniqueResult();
        } catch (HibernateException ex) {
            return null;
        } finally {
            if (session != null)
                session.close();
        }
        return style;
    }
}
