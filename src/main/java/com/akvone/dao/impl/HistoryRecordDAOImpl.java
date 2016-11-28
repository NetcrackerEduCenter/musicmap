package com.akvone.dao.impl;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.dao.HistoryRecordDAO;
import com.akvone.entity.HistoryRecord;
import com.akvone.entity.Location;
import com.akvone.entity.Song;
import com.akvone.entity.User;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class HistoryRecordDAOImpl implements HistoryRecordDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void save(HistoryRecord historyRecord) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(historyRecord);
    }

    @Override
    public boolean exists(User user, Song song) {
        boolean exists = false;
        try {
            Session session = sessionFactory.openSession();
            Criteria historyRecordCriteria = session.createCriteria(HistoryRecord.class);
            historyRecordCriteria.add(Restrictions.eq("user", user));
            historyRecordCriteria.add(Restrictions.eq("song", song));
            if (historyRecordCriteria.uniqueResult() != null)
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
    public HistoryRecord getByUserAndSong(User user, Song song) {
        HistoryRecord historyRecord;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria historyRecordCriteria = session.createCriteria(HistoryRecord.class);
            historyRecordCriteria.add(Restrictions.eq("user", user));
            historyRecordCriteria.add(Restrictions.eq("song", song));
            historyRecord = (HistoryRecord) historyRecordCriteria.uniqueResult();
        } catch (HibernateException ex) {
            return null;
        } finally {
            if (session != null)
                session.close();
        }
        return historyRecord;
    }

    @Override
    public Set<HistoryRecord> getByLocation(Location location) {
        Set<HistoryRecord> historyRecords = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria historyRecordCriteria = session.createCriteria(HistoryRecord.class);
            historyRecordCriteria.add(Restrictions.eq("location", location));
            historyRecords = new HashSet<HistoryRecord>(historyRecordCriteria.list());
        } catch (HibernateException ex) {
            return null;
        } finally {
            if (session != null)
                session.close();
        }
        return historyRecords;
    }

    @Override
    public Long getUserCountByLocationId(Long locationId) {
        Session session=null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("select count(distinct user) from HistoryRecord where location.id = :locationId");
            query.setParameter("locationId", locationId);
            return (Long) query.uniqueResult();
        }
        catch (HibernateException ex) {
            return null;
        }
        finally {
            if (session!=null)
                session.close();
        }
    }

    @Override
    //not sure in quality
    public List<String> getTopStylesByLocation(Long locationId) {
        Session session=null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("select song.style.name from HistoryRecord  where location = :locationId group by song.style.name order by count(song.style)");
            query.setParameter("locationId", locationId);
            return (query.list().isEmpty()?null:query.list());
        }
        catch (HibernateException ex) {
            return null;
        }
        finally {
            if(session!=null)
                session.close();
        }
    }
}
