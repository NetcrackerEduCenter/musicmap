package com.akvone.entity;

import javax.persistence.*;

/**
 * Created by Kirill on 10.11.2016.
 */
@Entity
@Table(name = "USERS", schema = "musicDB", catalog = "")
public class User {
    private Long id;
    private Long vkId;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "vk_id", nullable = true)
    public Long getVkId() {
        return vkId;
    }

    public void setVkId(Long vkId) {
        this.vkId = vkId;
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
        result = 31 * result + (vkId != null ? vkId.hashCode() : 0);
        return result;
    }
}
