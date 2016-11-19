package com.akvone.dao;

import com.akvone.entity.HistoryRecord;
import java.util.Set;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

public interface HistoryRecordDAO {

    void add(HistoryRecord historyRecord);

    void delete(HistoryRecord historyRecord);

    Set<HistoryRecord> findAll();

    Long getUserCountByLocationId(Long locationId);

    Set<String> getTopStylesByLocation(Long locationId);
}
