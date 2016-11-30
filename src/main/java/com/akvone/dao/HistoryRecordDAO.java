package com.akvone.dao;

import com.akvone.entity.*;

import java.util.List;
import java.util.Set;

public interface HistoryRecordDAO {

    void save(HistoryRecord historyRecord);

    boolean exists(User user, Song song);

    HistoryRecord getByUserAndSong(User user, Song song);

    Set<HistoryRecord> getByLocation(Location location);

    List<String> getTopStylesByLocation(Long locationId);

    Long getUserCountByLocationId(Long locationId);

}
