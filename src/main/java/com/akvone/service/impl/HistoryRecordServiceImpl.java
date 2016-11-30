package com.akvone.service.impl;

import com.akvone.dao.HistoryRecordDAO;
import com.akvone.entity.*;
import com.akvone.service.HistoryRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HistoryRecordServiceImpl implements HistoryRecordService {

    @Autowired
    private HistoryRecordDAO historyRecordDAO;

    @Override
    public HistoryRecord add(User user, Song song, Location location){
        if(!historyRecordDAO.exists(user,song)){
            HistoryRecord historyRecord = new HistoryRecord();
            historyRecord.setUser(user);
            historyRecord.setSong(song);
            historyRecord.setLocation(location);
            historyRecordDAO.save(historyRecord);
        }
        return historyRecordDAO.getByUserAndSong(user,song);
    }

    @Override
    public Long getUserCountByLocationId(Long locationId) {
        return historyRecordDAO.getUserCountByLocationId(locationId);
    }

    @Override
    public List<String> getStyleTop(Long locationId) {
        return historyRecordDAO.getTopStylesByLocation(locationId);
    }
}
