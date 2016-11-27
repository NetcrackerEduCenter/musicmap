package com.akvone.service;

import com.akvone.entity.Singer;
import com.akvone.entity.Song;
import com.akvone.entity.Style;

/**
 * Created by nikitafedorovv on 26/11/2016.
 */

public interface SongService {

    Song add(Long vkId, Singer singer, Style style);

}
