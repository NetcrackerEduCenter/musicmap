package com.akvone.service;

import java.util.Set;

/**
 * Created by ToGo on 20.11.2016.
 */
public interface HistoryService {
    Long getUserCountByLocationId(Long locationId);

    Set<String> getGenreTop(Long locationId);
}
