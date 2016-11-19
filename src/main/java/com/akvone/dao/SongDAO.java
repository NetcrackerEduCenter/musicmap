package com.akvone.dao;

import com.akvone.entity.Song;
import java.util.Set;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

public interface SongDAO {

    boolean add(Song song);

    void update(Song song);

    Song findById(Long id);

    void delete(Song song);

    Set<Song> findAll();
}
