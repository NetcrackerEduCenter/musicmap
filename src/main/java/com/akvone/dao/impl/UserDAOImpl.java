package com.akvone.dao.impl;

import com.akvone.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.akvone.dao.*;
import java.util.HashSet;
import java.util.Set;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public boolean add(User user) {
        if (hibernateTemplate.find("FROM User user WHERE user.vkId = " + user.getVkId()).isEmpty()) {
            hibernateTemplate.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void update(User user) {
        hibernateTemplate.update(user);
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return hibernateTemplate.get(User.class, id);
    }

    @Transactional
    public void delete(User user) {
        hibernateTemplate.delete(user);
    }

    @Transactional(readOnly = true)
    public Set<User> findAll() {
        return new HashSet(hibernateTemplate.find("from User"));
    }

}