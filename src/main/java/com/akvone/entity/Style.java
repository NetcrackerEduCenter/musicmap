package com.akvone.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

@Entity
@Table(name = "STYLES", schema = "musicDB", catalog = "")
public class Style implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false, unique = true)
    private String name;

//    @ManyToMany
//    @JoinTable(name = "SINGERS_STYLES",
//            joinColumns = {@JoinColumn(name = "style_id")},
//            inverseJoinColumns = {@JoinColumn(name = "singer_id")})
//    private Set<Singer> singers = new HashSet<Singer>();

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

//    public Set<Singer> getSingers() {
//        return singers;
//    }
//
//    public void setSingers(Set<Singer> singers) {
//        this.singers = singers;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Style)) return false;

        Style that = (Style) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        if (singers != null ? !singers.equals(that.singers) : that.singers != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 3517 * result + (name != null ? name.hashCode() : 0);
//        result = 3517 * result + (singers != null ? singers.hashCode() : 0);
        return result;
    }
}
