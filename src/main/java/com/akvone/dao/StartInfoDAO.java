package com.akvone.dao;

import javax.transaction.Transactional;

import com.akvone.entity.StartInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public class StartInfoDAO implements IStartInfoDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public boolean addStartInfo(StartInfo startInfo) {
        hibernateTemplate.save(startInfo);
        return false;
    }
}
