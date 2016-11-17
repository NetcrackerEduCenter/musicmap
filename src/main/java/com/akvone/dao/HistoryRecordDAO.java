package com.akvone.dao;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.entity.HistoryRecord;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


//@javax.transaction.Transactional
@Repository
public class HistoryRecordDAO extends HibernateDaoSupport implements IHistoryRecordDAO {

    @Transactional
    public void add(HistoryRecord historyRecord) {
        getHibernateTemplate().save(historyRecord);
    }

    @Transactional
    public void delete(HistoryRecord historyRecord) {
        getHibernateTemplate().delete(historyRecord);
    }

    @Transactional(readOnly = true)
    public Set<HistoryRecord> findAll() {
        return new HashSet(getHibernateTemplate().find("FROM com.akvone.entity.HistoryRecord"));
    }
}
