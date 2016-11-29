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
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "vk_id", unique = true)
    private Long vkId;

    @ManyToOne
    @JoinColumn(name = "singer_id", referencedColumnName = "id")
    private Singer singer;

    @ManyToOne
    @JoinColumn(name = "style_id", referencedColumnName = "id")
    private Style style;

    public Song(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVkId() {
        return vkId;
    }

    public void setVkId(Long vkId) {
        this.vkId = vkId;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Song)) return false;

        Song that = (Song) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (singer != null ? !singer.equals(that.singer) : that.singer != null) return false;
        if (style != null ? !style.equals(that.style) : that.style != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = singer != null ? singer.hashCode() : 0;
        result = 3517 * result + (id != null ? id.hashCode() : 0);
        result = 3517 * result + (style != null ? style.hashCode() : 0);
        return result;
    }
}
