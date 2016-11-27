package com.akvone.router;

import com.akvone.entity.HistoryRecord;
import com.akvone.entity.JSONUserData;

import java.util.Set;

/**
 * Created by nikitafedorovv on 25/11/2016.
 */

public interface UserDataRouter {
    Set<HistoryRecord> route(JSONUserData jsonUserData);
}
