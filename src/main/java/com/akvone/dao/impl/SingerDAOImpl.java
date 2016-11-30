package com.akvone.dao.impl;

import com.akvone.entity.Singer;
import com.akvone.dao.SingerDAO;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SingerDAOImpl implements SingerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Singer singer) {
        sessionFactory.getCurrentSession().saveOrUpdate(singer);
    }

    @Override
    public boolean exists(String name) {
        boolean exists = false;
        try {
            Criteria singerCriteria = sessionFactory.getCurrentSession().createCriteria(Singer.class);
            singerCriteria.add(Restrictions.eq("name", name));
            exists = !singerCriteria.list().isEmpty();
        } catch (HibernateException ex) {
            return false;
        }
        return exists;
    }

    @Override
    public Singer getByName(String name) {
        Singer singer;
        try {
            Criteria singerCriteria = sessionFactory.getCurrentSession().createCriteria(Singer.class);
            singerCriteria.add(Restrictions.eq("name", name));
            singer = (Singer) singerCriteria.list().get(0);
        } catch (HibernateException ex) {
            return null;
        }
        return singer;
    }
}
