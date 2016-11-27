package com.akvone.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Kruchon on 19.11.2016.
 */

public class JSONUserData {
    @JsonProperty("userID")
    private String vkIdLine;

    @JsonProperty("x")
    private Float x;

    @JsonProperty("y")
    private Float y;

    @JsonProperty("locationID")
    private Long locationId;

    @JsonProperty("audios")
    private List<JSONSong> songs;

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getVkIdLine() {
        return vkIdLine;
    }

    public void setVkIdLine(String vkIdLine) {
        this.vkIdLine = vkIdLine;
    }

    public List<JSONSong> getSongs() {
        return songs;
    }

    public void setSongs(List<JSONSong> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "JSONUserData{" +
                "vkIdLine='" + vkIdLine + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", locationId=" + locationId +
                ", songs=" + songs +
                '}';
    }
}
