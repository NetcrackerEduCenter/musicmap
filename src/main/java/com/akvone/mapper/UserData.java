package com.akvone.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ToGo on 15.11.2016.
 */
public class UserData {

    private Map<String,Object> coords ;
    private Long locationId;
    private Long vkId;
    private String audioList;

    public Long getVkId() {
        return vkId;
    }

    public void setVkId(Long vkId) {
        this.vkId = vkId;
    }

    public Map<String,Object> getCoords() {
        return coords;
    }

    public void setCoords(Map<String,Object> coords) {
        this.coords = coords;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getAudioList() {
        return audioList;
    }

    public void setAudioList(String  audioList) {
        this.audioList = audioList;
    }
}
