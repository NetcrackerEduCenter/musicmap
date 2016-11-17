package com.akvone.dao;

import com.akvone.entity.HistoryRecord;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */
public interface IHistoryRecordDAO {

    void add(HistoryRecord historyRecord);

    void delete(HistoryRecord historyRecord);
}
