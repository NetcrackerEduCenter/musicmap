package com.akvone.dao;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.entity.Style;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


//@javax.transaction.Transactional
@Repository
public class StyleDAO extends HibernateDaoSupport implements IStyleDAO {

    @Transactional
    public boolean add(Style style) {
        if (getHibernateTemplate().find("select * from Style style where style.name = " + style.getName()).isEmpty()) {
            getHibernateTemplate().save(style);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void update(Style style) {
        getHibernateTemplate().update(style);
    }

    @Transactional(readOnly = true)
    public Style findById(Long id) {
        return getHibernateTemplate().get(Style.class, id);
    }

    @Transactional
    public void delete(Style style) {
        getHibernateTemplate().delete(style);
    }

    @Transactional(readOnly = true)
    public Set<Style> findAll() {
        return new HashSet(getHibernateTemplate().find("FROM com.akvone.entity.Style"));
    }
}
