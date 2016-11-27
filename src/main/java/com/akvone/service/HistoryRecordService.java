package com.akvone.service;

import com.akvone.entity.HistoryRecord;
import com.akvone.entity.Location;
import com.akvone.entity.Song;
import com.akvone.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by ToGo on 20.11.2016.
 */

public interface HistoryRecordService {

    HistoryRecord add(User user, Song song, Location location);

    Long getUserCountByLocationId(Long locationId);

    //List<String> getStyleTop(Long locationId);

    Set<String> getStyleTop(Long locationId);

}
