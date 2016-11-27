package com.akvone.dao.impl;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.entity.Song;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.akvone.dao.*;

@Repository
public class SongDAOImpl implements SongDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Song song) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(song);
    }

    @Override
    public boolean exists(long vkId) {
        boolean exists = false;
        try {
            Session session = sessionFactory.openSession();
            Criteria songCriteria = session.createCriteria(Song.class);
            songCriteria.add(Restrictions.eq("vk_id", vkId));
            if (songCriteria.uniqueResult() != null)
                exists = true;
            else
                exists = false;
            session.close();
        } catch (HibernateException ex) {
            return false;
        }
        return exists;
    }

    @Override
    public Song getByVkId(long vkId) {
        Song song;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria songCriteria = session.createCriteria(Song.class);
            songCriteria.add(Restrictions.eq("vk_id", vkId));
            song = (Song) songCriteria.uniqueResult();
        } catch (HibernateException ex) {
            return null;
        } finally {
            if (session != null)
                session.close();
        }
        return song;
    }

}
