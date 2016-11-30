package com.akvone.service;

import com.akvone.entity.HistoryRecord;
import com.akvone.entity.JSONUserData;

import java.util.Set;

public interface RouterService {
    Set<HistoryRecord> route(JSONUserData jsonUserData);
}
