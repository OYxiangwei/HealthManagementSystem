package com.oy.dao;

import com.oy.entity.EnergyDate;
import com.oy.entity.UserSportHistory;

import java.util.List;

public interface UserSportHistoryMapper {
    public int insert(UserSportHistory userSportHistory);

    public List<UserSportHistory> getAll(int userId);

    public List<EnergyDate> getSumConsumeEnergy(int userId);
}
