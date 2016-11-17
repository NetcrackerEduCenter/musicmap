package com.akvone.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

@Entity
@Table(name = "SINGERS", schema = "musicDB", catalog = "")
public class Singer {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "singers")
    private Set<Style> styles = new HashSet<Style>();

//    @OneToMany(mappedBy = "singer")
//    private Set<Song> songs = new HashSet<Song>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Style> getStyles() {
        return styles;
    }

    public void setStyles(Set<Style> styles) {
        this.styles = styles;
    }

//    public void setSongs(Set<Song> songs) {
//        this.songs = songs;
//    }
//
//    public Set<Song> getSongs() {
//        return songs;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Song)) return false;

        Singer that = (Singer) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (styles != null ? !styles.equals(that.styles) : that.styles != null) return false;
        //if (songs != null ? !songs.equals(that.songs) : that.songs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 3517 * result + (name != null ? name.hashCode() : 0);
        result = 3517 * result + (styles != null ? styles.hashCode() : 0);
        //result = 3517 * result + (songs != null ? songs.hashCode() : 0);
        return result;
    }
}
