package com.akvone.dao.impl;

import com.akvone.dao.UserDAO;
import com.akvone.entity.User;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public boolean exists(Long vkId) {
        boolean exists = false;
        try {
            Criteria userCriteria = sessionFactory.getCurrentSession().createCriteria(User.class);
            userCriteria.add(Restrictions.eq("vkId", vkId));
            exists = !userCriteria.list().isEmpty();
        } catch (HibernateException ex) {
            return false;
        }
        return exists;
    }

    @Override
    public User getByVkId(Long vkId) {
        User user;
        try {
            Criteria userCriteria = sessionFactory.getCurrentSession().createCriteria(User.class);
            userCriteria.add(Restrictions.eq("vkId", vkId));
            user = (User) userCriteria.list().get(0);
        } catch (HibernateException ex) {
            return null;
        }
        return user;
    }
}