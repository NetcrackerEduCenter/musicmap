package com.akvone.dao.impl;

import com.akvone.entity.Song;
import com.akvone.dao.SongDAO;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SongDAOImpl implements SongDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Song song) {
        sessionFactory.getCurrentSession().saveOrUpdate(song);
    }

    @Override
    public boolean exists(Long vkId) {
        boolean exists = false;
        try {
            Criteria songCriteria = sessionFactory.getCurrentSession().createCriteria(Song.class);
            songCriteria.add(Restrictions.eq("vkId", vkId));
            exists = !songCriteria.list().isEmpty();
        } catch (HibernateException ex) {
            return false;
        }
        return exists;
    }

    @Override
    public Song getByVkId(Long vkId) {
        Song song;
        try {
            Criteria songCriteria = sessionFactory.getCurrentSession().createCriteria(Song.class);
            songCriteria.add(Restrictions.eq("vkId", vkId));
            song = (Song) songCriteria.list().get(0);
        } catch (HibernateException ex) {
            return null;
        }
        return song;
    }
}
