package com.akvone.service.impl;

import com.akvone.dao.HistoryRecordDAO;
import com.akvone.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ToGo on 20.11.2016.
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRecordDAO historyRecordDAO;

    @Override
    public Long getUserCountByLocationId(Long locationId) {
        return historyRecordDAO.getUserCountByLocationId(locationId);
    }

    @Override
    public Set<String> getGenreTop(Long locationId) {
        Set<String> topStyles = historyRecordDAO.getTopStylesByLocation(locationId);
        HashSet<String> styles = new HashSet<String>();
        for (String style:topStyles) {
            styles.add(style);
        }
        return styles;
    }
}
