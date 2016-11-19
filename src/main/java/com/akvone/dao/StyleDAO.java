package com.akvone.dao;

import com.akvone.entity.Style;
import java.util.Set;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

public interface StyleDAO {

    boolean add(Style style);

    void update(Style style);

    Style findById(Long id);

    void delete(Style style);

    Set<Style> findAll();
}
