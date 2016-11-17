package com.akvone.dao;

import com.akvone.entity.Singer;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */
public interface ISingerDAO {

    boolean add(Singer singer);

    void update(Singer singer);

    Singer findById(Long id);

    void delete(Singer singer);
}
