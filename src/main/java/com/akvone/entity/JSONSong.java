package com.akvone.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Kruchon on 19.11.2016.
 */

public class JSONSong {
    @JsonProperty("aid")
    private Long id;

    @JsonProperty("artist")
    private String singer;

    @JsonProperty("genre")
    private String styleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    @Override
    public String toString() {
        return "JSONSong{" +
                "id=" + id +
                ", singer='" + singer + '\'' +
                ", styleName='" + styleName + '\'' +
                '}';
    }
}
