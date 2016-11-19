package com.akvone.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

@Entity
@Table(name = "LOCATIONS", schema = "musicDB", catalog = "")
public class Location implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

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

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 3517 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
