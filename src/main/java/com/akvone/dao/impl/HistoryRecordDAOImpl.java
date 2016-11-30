package com.akvone.dao.impl;

import com.akvone.dao.HistoryRecordDAO;
import com.akvone.entity.HistoryRecord;
import com.akvone.entity.Location;
import com.akvone.entity.Song;
import com.akvone.entity.User;

import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class HistoryRecordDAOImpl implements HistoryRecordDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(HistoryRecord historyRecord) {
        sessionFactory.getCurrentSession().saveOrUpdate(historyRecord);
    }

    @Override
    public boolean exists(User user, Song song) {
        boolean exists = false;
        try {
            Criteria historyRecordCriteria = sessionFactory.getCurrentSession().createCriteria(HistoryRecord.class);
            historyRecordCriteria.add(Restrictions.eq("user", user));
            historyRecordCriteria.add(Restrictions.eq("song", song));
            exists = !historyRecordCriteria.list().isEmpty();
        } catch (HibernateException ex) {
            return false;
        }
        return exists;
    }

    @Override
    public HistoryRecord getByUserAndSong(User user, Song song) {
        HistoryRecord historyRecord;
        try {
            Criteria historyRecordCriteria = sessionFactory.getCurrentSession().createCriteria(HistoryRecord.class);
            historyRecordCriteria.add(Restrictions.eq("user", user));
            historyRecordCriteria.add(Restrictions.eq("song", song));
            historyRecord = (HistoryRecord) historyRecordCriteria.list().get(0);
        } catch (HibernateException ex) {
            return null;
        }
        return historyRecord;
    }

    @Override
    public Set<HistoryRecord> getByLocation(Location location) {
        Set<HistoryRecord> historyRecords = null;
        try {
            Criteria historyRecordCriteria = sessionFactory.getCurrentSession().createCriteria(HistoryRecord.class);
            historyRecordCriteria.add(Restrictions.eq("location", location));
            historyRecords = new HashSet<HistoryRecord>(historyRecordCriteria.list());
        } catch (HibernateException ex) {
            return null;
        }
        return historyRecords;
    }

    @Override
    public Long getUserCountByLocationId(Long locationId) {
        try {
            Query query = sessionFactory.getCurrentSession().createQuery("select count(distinct user) from HistoryRecord where location.id = :locationId");
            query.setParameter("locationId", locationId);
            return (Long) query.uniqueResult();
        }
        catch (HibernateException ex) {
            return null;
        }
    }

    @Override
    //not sure in quality
    public List<String> getTopStylesByLocation(Long locationId) {
        try {
            Query query = sessionFactory.getCurrentSession().createQuery("select song.style.name from HistoryRecord  where location = :locationId group by song.style.name order by count(song.style.name)");
            query.setParameter("locationId", locationId);
            return (query.list().isEmpty()?null:query.list());
        }
        catch (HibernateException ex) {
            return null;
        }
    }
}
