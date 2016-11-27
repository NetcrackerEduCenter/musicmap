package com.akvone.service.impl;

import com.akvone.dao.HistoryRecordDAO;
import com.akvone.dao.LocationDAO;
import com.akvone.entity.*;
import com.akvone.service.HistoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ToGo on 20.11.2016.
 */

@Service
public class HistoryRecordRecordServiceImpl implements HistoryRecordService {

    @Autowired
    private HistoryRecordDAO historyRecordDAO;

    @Autowired
    private LocationDAO locationDAO;

    @Override
    public HistoryRecord add(User user, Song song, Location location){
        if(!historyRecordDAO.exists(user,song)){
        } else {
            HistoryRecord historyRecord = new HistoryRecord();
            historyRecord.setUser(user);
            historyRecord.setSong(song);
            historyRecord.setLocation(location);
            historyRecordDAO.save(historyRecord);
        }
        return historyRecordDAO.getByUserAndSong(user,song);
    }

//    //version of two last methods (by nikitafedorovv)
//
//    @Override
//    public Long getUserCountByLocationId(Long locationId){
//        return historyRecordDAO.getUserCountByLocation(locationDAO.getById(locationId));
//    }
//
//    @Override
//    public List<String> getStyleTop(Long locationId) {
//        List<Style> topStyles = historyRecordDAO.getTopStylesByLocation(locationDAO.getById(locationId));
//        List<String> topStylesStr = new ArrayList<String>();
//        for (int i = 0; (i < 5) && (i < topStyles.size()); i++){
//            topStylesStr.add(topStyles.get(i).getName());
//        }
//        return topStylesStr;
//    }

    @Override
    public Long getUserCountByLocationId(Long locationId) {
        return historyRecordDAO.getUserCountByLocationId(locationId);
    }

    @Override
    public Set<String> getStyleTop(Long locationId) {
        Set<String> topStyles = historyRecordDAO.getTopStylesByLocation(locationId);
        HashSet<String> styles = new HashSet<String>();
        for (String style:topStyles) {
            styles.add(style);
        }
        return styles;
    }
}
