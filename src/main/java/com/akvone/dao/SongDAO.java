package com.akvone.dao;

import com.akvone.entity.Song;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

public interface SongDAO {

    boolean exists(long vkId);

    void save(Song song);

    Song getByVkId(long vkId);

}
