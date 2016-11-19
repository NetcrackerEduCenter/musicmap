package com.akvone.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by nikitafedorovv on 18/11/2016.
 */

@Entity
@Table(name = "USERS", schema = "musicDB", catalog = "")
public class User implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "vk_id", nullable = false, unique = true)
    private Long vkId;

    @Basic
    @Column(name = "coordinates")
    private String coordinates;

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

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (vkId != null ? !vkId.equals(that.vkId) : that.vkId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 3517 * result + (vkId != null ? vkId.hashCode() : 0);
        return result;
    }
}
