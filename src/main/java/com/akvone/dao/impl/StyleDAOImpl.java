package com.akvone.dao.impl;

import com.akvone.dao.StyleDAO;
import com.akvone.entity.Style;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StyleDAOImpl implements StyleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean exists(Long id) {
        boolean exists = false;
        try {
            Criteria styleCriteria = sessionFactory.getCurrentSession().createCriteria(Style.class);
            styleCriteria.add(Restrictions.eq("id", id));

            exists = !styleCriteria.list().isEmpty();
        } catch (HibernateException ex) {
            return false;
        }
        return exists;
    }

    @Override
    public Style getById(Long id) {
        Style style;
        try {
            Criteria styleCriteria = sessionFactory.getCurrentSession().createCriteria(Style.class);
            styleCriteria.add(Restrictions.eq("id", id));
            style = (Style) styleCriteria.list().get(0);
        } catch (HibernateException ex) {
            return null;
        }
        return style;
    }
}
