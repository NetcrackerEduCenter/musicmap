package com.akvone.entity;

import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

@Entity
@Table(name = "LOCATIONS", schema = "musicDB", catalog = "")
public class Location {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

//    @Basic
//    @Column(name = "points", nullable = false)
//    private String points;

//    @OneToMany(mappedBy = "location")
//    private Set<HistoryRecord> historyRecords = new HashSet<HistoryRecord>();

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

//    public String getPoints() {
//        return points;
//    }
//
//    public void setPoints(String points) {
//        this.points = points;
//    }

//    public Set<HistoryRecord> getHistoryRecords() {
//        return historyRecords;
//    }
//
//    public void setHistoryRecords(Set<HistoryRecord> historyRecords) {
//        this.historyRecords = historyRecords;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || !(o instanceof Song)) return false;
//
//        Location that = (Location) o;
//
//        if (id != null ? !id.equals(that.id) : that.id != null) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        if (points != null ? !points.equals(that.points) : that.points != null) return false;
//
//        return true;
//    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 3517 * result + (name != null ? name.hashCode() : 0);
        //result = 3517 * result + (points != null ? points.hashCode() : 0);
        return result;
    }
}
