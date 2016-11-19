package com.akvone.dao.impl;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.dao.*;
import com.akvone.entity.HistoryRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.Set;

@Repository
public class HistoryRecordDAOImpl implements HistoryRecordDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void add(HistoryRecord historyRecord) {
        hibernateTemplate.save(historyRecord);
    }

    @Transactional
    public void delete(HistoryRecord historyRecord) {
        hibernateTemplate.delete(historyRecord);
    }

    @Transactional(readOnly = true)
    public Set<HistoryRecord> findAll() {
        return new HashSet(hibernateTemplate.find("from HistoryRecord"));
    }
}
