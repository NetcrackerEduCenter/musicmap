package com.akvone.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "HISTORY", schema = "musicDB", catalog = "")
@IdClass(HistoryRecordPK.class)
public class HistoryRecord implements Serializable {

    public HistoryRecord() {}

    public HistoryRecord(HistoryRecordPK historyRecordPK) {
        song = historyRecordPK.getSong();
        user = historyRecordPK.getUser();
    }

    @Id
    private User user;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    private Location location;

    @Id
    private Song song;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

        HistoryRecord that = (HistoryRecord) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (song != null ? !song.equals(that.song) : that.song != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 3517 * result + (location != null ? location.hashCode() : 0);
        result = 3517 * result + (song != null ? song.hashCode() : 0);
        return result;
    }
}