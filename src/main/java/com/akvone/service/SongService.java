package com.akvone.service;

import com.akvone.entity.Singer;
import com.akvone.entity.Song;
import com.akvone.entity.Style;

public interface SongService {

    Song add(Long vkId, Singer singer, Style style);

}
