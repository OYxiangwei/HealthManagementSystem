package com.oy.service;

import com.oy.entity.UserEverydayFoodSituation;
import com.oy.entity.UserFoodHistory;

import java.util.List;

public interface UserFoodHistoryService {
    public int insertUserFoodHistory(UserFoodHistory userFoodHistory);

    public List<UserEverydayFoodSituation> getAllUserFoodHistory(int userId);
}
