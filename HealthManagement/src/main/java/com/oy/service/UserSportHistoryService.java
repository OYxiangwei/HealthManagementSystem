package com.oy.service;

import com.oy.entity.UserEverydaySportSituation;
import com.oy.entity.UserSportHistory;

import java.util.List;

public interface UserSportHistoryService {
    public int insertUserSportHistory(UserSportHistory userSportHistory);

    public List<UserEverydaySportSituation> getAllUserSportHistory(int userId);
}
