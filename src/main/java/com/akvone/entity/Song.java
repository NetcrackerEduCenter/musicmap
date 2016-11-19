package com.akvone.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

@Entity
@Table(name = "SONGS", schema = "musicDB", catalog = "")
public class Song implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "singer_id", referencedColumnName = "id")
    private Singer singer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Song)) return false;

        Song that = (Song) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (singer != null ? !singer.equals(that.singer) : that.singer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 3517 * result + (singer != null ? singer.hashCode() : 0);
        return result;
    }
}
