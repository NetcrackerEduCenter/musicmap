package com.akvone.dao;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.entity.Singer;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

//@javax.transaction.Transactional
@Repository
public class SingerDAO extends HibernateDaoSupport implements ISingerDAO {

    @Transactional
    public boolean add(Singer singer) {
        if (getHibernateTemplate().find("select * from Singer singer where singer.name = " + singer.getName()).isEmpty()) {
            getHibernateTemplate().save(singer);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void update(Singer singer) {
        getHibernateTemplate().update(singer);
    }

    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return getHibernateTemplate().get(Singer.class, id);
    }

    @Transactional
    public void delete(Singer singer) {
        getHibernateTemplate().delete(singer);
    }

    @Transactional(readOnly = true)
    public Set<Singer> findAll() {
        return new HashSet(getHibernateTemplate().find("FROM com.akvone.entity.Singer"));
    }

}
