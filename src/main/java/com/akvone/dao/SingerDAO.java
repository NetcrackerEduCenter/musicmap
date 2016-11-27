package com.akvone.dao;

import com.akvone.entity.Singer;
import java.util.Set;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

public interface SingerDAO {

    void save(Singer singer);

    boolean exists(String name);

    Singer getByName(String name);

}
