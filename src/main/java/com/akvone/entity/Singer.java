package com.akvone.entity;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

@Entity
@Table(name = "SINGERS", schema = "musicDB", catalog = "")
public class Singer implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    //@Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "name", nullable = false, unique = true, columnDefinition = "NVARCHAR(255)")
    private String name;

    public Singer(){}

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Song)) return false;

        Singer that = (Singer) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 3517 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
