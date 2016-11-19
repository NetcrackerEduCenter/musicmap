package com.akvone.dao.impl;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.dao.*;
import com.akvone.entity.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.Set;

@Repository
public class StyleDAOImpl implements StyleDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public boolean add(Style style) {
        if (hibernateTemplate.find("from Style style where style.name = " + style.getName()).isEmpty()) {
            hibernateTemplate.save(style);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void update(Style style) {
        hibernateTemplate.update(style);
    }

    @Transactional(readOnly = true)
    public Style findById(Long id) {
        return hibernateTemplate.get(Style.class, id);
    }

    @Transactional
    public void delete(Style style) {
        hibernateTemplate.delete(style);
    }

    @Transactional(readOnly = true)
    public Set<Style> findAll() {
        return new HashSet(hibernateTemplate.find("FROM Style"));
    }
}
