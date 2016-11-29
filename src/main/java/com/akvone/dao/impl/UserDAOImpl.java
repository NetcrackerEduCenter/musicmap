package com.akvone.dao.impl;

import com.akvone.entity.User;
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
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public boolean exists(Long vkId) {
        boolean exists = false;
        try {
            Session session = sessionFactory.openSession();
            Criteria userCriteria = session.createCriteria(User.class);
            userCriteria.add(Restrictions.eq("vkId", vkId));
            exists = !userCriteria.list().isEmpty();
            session.close();
        } catch (HibernateException ex) {
            return false;
        }
        return exists;
    }

    @Override
    public User getByVkId(Long vkId) {
        User user;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria userCriteria = session.createCriteria(User.class);
            userCriteria.add(Restrictions.eq("vkId", vkId));
            user = (User) userCriteria.list().get(0);
        } catch (HibernateException ex) {
            return null;
        } finally {
            if (session != null)
                session.close();
        }
        return user;
    }
}