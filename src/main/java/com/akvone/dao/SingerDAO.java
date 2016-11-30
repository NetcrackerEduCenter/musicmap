package com.akvone.dao;

import com.akvone.entity.Singer;

public interface SingerDAO {

    void save(Singer singer);

    boolean exists(String name);

    Singer getByName(String name);

}
