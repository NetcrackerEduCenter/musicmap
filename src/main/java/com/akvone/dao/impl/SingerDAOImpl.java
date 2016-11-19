package com.akvone.dao.impl;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.entity.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.akvone.dao.*;
import java.util.HashSet;
import java.util.Set;

@Repository
public class SingerDAOImpl implements SingerDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public boolean add(Singer singer) {
        if (hibernateTemplate.find("from Singer singer where singer.name = " + singer.getName()).isEmpty()) {
            hibernateTemplate.save(singer);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void update(Singer singer) {
        hibernateTemplate.update(singer);
    }

    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return hibernateTemplate.get(Singer.class, id);
    }

    @Transactional
    public void delete(Singer singer) {
        hibernateTemplate.delete(singer);
    }

    @Transactional(readOnly = true)
    public Set<Singer> findAll() {
        return new HashSet(hibernateTemplate.find("FROM Singer"));
    }

}
