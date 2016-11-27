package com.akvone.router.impl;

import com.akvone.entity.*;
import com.akvone.router.UserDataRouter;
import com.akvone.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by nikitafedorovv on 22/11/2016.
 */

@Component
public class UserDataRouterImpl implements UserDataRouter {

    @Autowired
    private UserService userService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private StyleService styleService;

    @Autowired
    private SingerService singerService;

    @Autowired
    private SongService songService;

    @Autowired
    private HistoryRecordService historyRecordService;

    public Set<HistoryRecord> route(JSONUserData jsonUserData){

        User user = userService.add(Long.parseLong(jsonUserData.getVkIdLine()),jsonUserData.getX(),jsonUserData.getY());

        Location location = locationService.getById(jsonUserData.getLocationId());

        List<JSONSong> songs = jsonUserData.getSongs();
        Set<HistoryRecord> historyRecords = new HashSet<HistoryRecord>();
        for(Iterator<JSONSong> i = songs.iterator(); i.hasNext(); ) {
            JSONSong jsonSong = i.next();

            Style style = styleService.getByName(jsonSong.getStyleName());
            Singer singer = singerService.add(jsonSong.getSinger());
            Song song = songService.add(jsonSong.getId(), singer, style);
            HistoryRecord historyRecord = historyRecordService.add(user,song,location);

            historyRecords.add(historyRecord);
        }
        return historyRecords;
    }
}