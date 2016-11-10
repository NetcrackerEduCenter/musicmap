package com.akvone.dao;

import javax.transaction.Transactional;

import com.akvone.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public class UserDAO implements IUserDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean addUser(User user) {
        hibernateTemplate.save(user);
        return false;
    }
}