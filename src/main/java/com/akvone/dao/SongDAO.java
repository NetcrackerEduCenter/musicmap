package com.akvone.dao;

import com.akvone.entity.Song;

/**
 * Created by nikitafedorovv on 15/11/2016.
 */

public interface SongDAO {

    boolean exists(Long vkId);

    void save(Song song);

    Song getByVkId(Long vkId);

}
