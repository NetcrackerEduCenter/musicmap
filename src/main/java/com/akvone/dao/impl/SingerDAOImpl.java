package com.akvone.dao.impl;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.entity.Singer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.akvone.dao.*;

@Repository
public class SingerDAOImpl implements SingerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Singer singer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(singer);
    }

    @Override
    public boolean exists(String name) {
        boolean exists = false;
        try {
            Session session = sessionFactory.openSession();
            Criteria styleCriteria = session.createCriteria(Singer.class);
            styleCriteria.add(Restrictions.eq("name", name));
            if (styleCriteria.uniqueResult() != null)
                exists = true;
            else
                exists = false;
            session.close();
        } catch (HibernateException ex) {
            return false;
        }
        return exists;
    }

    @Override
    public Singer getByName(String name) {
        Singer singer;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria singerCriteria = session.createCriteria(Singer.class);
            singerCriteria.add(Restrictions.eq("name", name));
            singer = (Singer) singerCriteria.uniqueResult();
        } catch (HibernateException ex) {
            return null;
        } finally {
            if (session != null)
                session.close();
        }
        return singer;
    }
}
