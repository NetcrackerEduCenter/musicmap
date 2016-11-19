package com.akvone.dao.impl;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

import com.akvone.dao.*;
import com.akvone.entity.HistoryRecord;
import com.akvone.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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

    @Transactional (readOnly = true)
    public Long getUserCountByLocationId(Long locationId){
        return ((BigDecimal) hibernateTemplate.find("select count (user_id)from History where location_id = ?", locationId)).longValue();
    }

    @Transactional
    public Set<String> getTopStylesByLocation(Long locationId) {
        return new HashSet(hibernateTemplate.find("select st.name from HISTORY h " +
                "left join SONGS s on s.id=h.song_id " +
                "left join SINGERS_STYLES ss on ss.singer_id=s.singer_id " +
                "left join STYLES st on ss.style_id=st.id " +
                "where h.location_id = "+locationId+" " +
                "group by st.name " +
                "Order by (count(st.id)) desc"));
    }
}
