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

    @Override
    @Transactional
    public void save(Song song) {
        Session session = sessionFactory.openSession();//.getCurrentSession();
        //session.persist(song);
        session.saveOrUpdate(song);
        session.close();
    }

    @Override
    public boolean exists(Long vkId) {
        boolean exists = false;
        try {
            Session session = sessionFactory.openSession();
            Criteria songCriteria = session.createCriteria(Song.class);
            songCriteria.add(Restrictions.eq("vkId", vkId));


            exists = !songCriteria.list().isEmpty();

            //exists = songCriteria.uniqueResult() != null;
            session.close();
        } catch (HibernateException ex) {
            return false;
        }
        return exists;
    }

    @Override
    public Song getByVkId(Long vkId) {
        Song song;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria songCriteria = session.createCriteria(Song.class);
            songCriteria.add(Restrictions.eq("vkId", vkId));
            song = (Song) songCriteria.list().get(0);
        } catch (HibernateException ex) {
            return null;
        } finally {
            if (session != null)
                session.close();
        }
        return song;
    }
}
