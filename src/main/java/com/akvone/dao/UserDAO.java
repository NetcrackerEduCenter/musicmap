package com.akvone.dao;

import com.akvone.entity.User;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

//@javax.transaction.Transactional
@Repository
public class UserDAO extends HibernateDaoSupport implements IUserDAO {

    @Transactional
    public boolean add(User user) {
        if (getHibernateTemplate().find("select * from User user where user.vkId = " + user.getVkId()).isEmpty()) {
            //по поводу этого запроса неуверен
            getHibernateTemplate().save(user);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void update(User user) {
        getHibernateTemplate().update(user);
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return getHibernateTemplate().get(User.class, id);
    }

    @Transactional
    public void delete(User user) {
        getHibernateTemplate().delete(user);
    }

    @Transactional(readOnly = true)
    public Set<User> findAll() {
        return new HashSet(getHibernateTemplate().find("from com.akvone.entity.User"));
    }

}