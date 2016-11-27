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

        User user;
        if ((jsonUserData.getVkIdLine() != "") && (jsonUserData.getVkIdLine() != null)){
            user = userService.add(Long.parseLong(jsonUserData.getVkIdLine()),jsonUserData.getX(),jsonUserData.getY());
        } else return null; //throw new RuntimeException("UserID has unacceptable format: " + jsonUserData.getVkIdLine());

        Location location = locationService.getById(jsonUserData.getLocationId());

        if (location == null) return null; //throw new RuntimeException("RegionID has not been found in database: " + jsonUserData.getLocationId());

        List<JSONSong> songs = jsonUserData.getSongs();
        Set<HistoryRecord> historyRecords = new HashSet<HistoryRecord>();
        for(JSONSong jsonSong: songs) {
            Style style = styleService.getByName(jsonSong.getStyleName());
            if (style == null) continue;

            Singer singer;
            if ((jsonSong.getSinger() == null) || (jsonSong.getSinger() == "")) singer = singerService.add("Unknown artist");
            else singer = singerService.add(jsonSong.getSinger());

            Song song;
            if (jsonSong.getId() == null) continue;
            else song = songService.add(jsonSong.getId(), singer, style);

            HistoryRecord historyRecord = historyRecordService.add(user,song,location);

            historyRecords.add(historyRecord);
        }
        return historyRecords;
    }
}