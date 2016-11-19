package com.akvone.dao;

import com.akvone.entity.Singer;
import java.util.Set;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

public interface SingerDAO {

    boolean add(Singer singer);

    void update(Singer singer);

    Singer findById(Long id);

    void delete(Singer singer);

    Set<Singer> findAll();
}
