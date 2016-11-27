package com.akvone.dao;

import com.akvone.entity.*;

import java.util.List;
import java.util.Set;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

public interface HistoryRecordDAO {

    void save(HistoryRecord historyRecord);

    boolean exists(User user, Song song);

    HistoryRecord getByUserAndSong(User user, Song song);

    Set<HistoryRecord> getByLocation(Location location);

    //Long getUserCountByLocation(Location location);

    //List<Style> getTopStylesByLocation(Location location);

    Set<String> getTopStylesByLocation(Long locationId);

    Long getUserCountByLocationId(Long locationId);

}
