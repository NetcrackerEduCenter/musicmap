package com.akvone.dao.impl;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.dao.*;
import com.akvone.entity.*;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class HistoryRecordDAOImpl implements HistoryRecordDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;  //оставил для двух последних методов (не мои) by nikitafedorovv

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

//    //version of two last methods (by nikitafedorovv)
//
//    @Override
//    public Long getUserCountByLocation(Location location){
//
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("select count(distinct R.user) from HistoryRecord R where R.location = :locationParameter");
//        query.setParameter("locationParameter", location);
//        query.setMaxResults(1);
//        if (!query.list().isEmpty()) {
//            return Long.parseLong(query.uniqueResult().toString()); //no idea whether it returns string or long/int value. just to insure (by nikitafedorovv)
//        }
//        return new Long(0);
//    }
//
//    @Override
//    public List<Style> getTopStylesByLocation(Location location) {
//        Session session = sessionFactory.getCurrentSession();
//
//        Query query = session.createQuery("select R.song.style from HistoryRecord R where R.location = :locationParameter group by R.song.style.name order by count(R.song.style)");
//        query.setParameter("locationParameter", location);
//
//        List topStyles = query.list();
//        if ((topStyles.size() > 0)&&(topStyles.get(0) instanceof Style)){
//            return (List<Style>)query.list();
//        }
//        return new ArrayList<Style>();
//    }

    @Override
    public Long getUserCountByLocationId(Long locationId) {
        return ((BigDecimal) hibernateTemplate.find("select count (User)from HistoryRecord where location.id = ?", locationId)).longValue();
    }

    @Override
    //not sure in quality
    public Set<String> getTopStylesByLocation(Long locationId) {
        return new HashSet(hibernateTemplate.find("select h from HistoryRecord h " +
                "left join h.song " +
                "left join SINGERS_STYLES ss on ss.singer_id=s.singer_id " +
                "left join STYLES st on ss.style_id=st.id " +
                "where h.location_id = "+locationId+" " +
                "group by st.name " +
                "Order by (count(st.id)) desc"));
    }
}
