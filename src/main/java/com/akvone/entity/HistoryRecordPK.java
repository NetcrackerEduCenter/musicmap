package com.akvone.entity;

import javax.persistence.*;
import java.io.Serializable;

public class HistoryRecordPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "song_id", referencedColumnName = "id", nullable = false)
    private Song song;

    public HistoryRecordPK() {}

    public HistoryRecordPK(User user, Song song) {
        this.user = user;
        this.song = song;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Song)) return false;

        HistoryRecordPK that = (HistoryRecordPK) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (song != null ? !song.equals(that.song) : that.song != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 3517 * result + (song != null ? song.hashCode() : 0);
        return result;
    }

}
