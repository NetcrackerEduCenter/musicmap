package com.akvone.dao;

import com.akvone.entity.Song;

public interface SongDAO {

    boolean exists(Long vkId);

    void save(Song song);

    Song getByVkId(Long vkId);

}
