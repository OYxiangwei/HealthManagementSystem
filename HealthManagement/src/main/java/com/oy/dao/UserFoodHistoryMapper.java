package com.oy.dao;

import com.oy.entity.EnergyDate;
import com.oy.entity.UserFoodHistory;

import java.util.List;

public interface UserFoodHistoryMapper {
    public int insert(UserFoodHistory userFoodHistory);

    public List<UserFoodHistory> getAll(int userId);

    public List<EnergyDate> getSumFoodEnergy(int userId);
}
