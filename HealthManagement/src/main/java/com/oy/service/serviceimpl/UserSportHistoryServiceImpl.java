package com.oy.service.serviceimpl;

import com.oy.dao.UserSportHistoryMapper;
import com.oy.entity.UserEverydaySportSituation;
import com.oy.entity.UserSportHistory;
import com.oy.service.UserSportHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class UserSportHistoryServiceImpl implements UserSportHistoryService {
    @Autowired
    private UserSportHistoryMapper userSportHistoryMapper;

    @Override
    public int insertUserSportHistory(UserSportHistory userSportHistory) {
        return userSportHistoryMapper.insert(userSportHistory);
    }

    @Override
    public List<UserEverydaySportSituation> getAllUserSportHistory(int userId) {
        List<UserSportHistory> userSportHistories = userSportHistoryMapper.getAll(userId);
        Map<Date,List<UserSportHistory>> userSportMap = new TreeMap<>();
        for (UserSportHistory userSportHistory:userSportHistories) {
            Date cDate = userSportHistory.getCollectDate();
            if(userSportMap.containsKey(cDate)){
            List<UserSportHistory> userSportHistories1 = userSportMap.get(cDate);
            userSportHistories1.add(userSportHistory);
            }else {
                List<UserSportHistory> userSportHistoryList = new ArrayList<>();
                userSportHistoryList.add(userSportHistory);
                userSportMap.put(cDate,userSportHistoryList);
            }
        }
        List<UserEverydaySportSituation> userEverydaySportSituations = new ArrayList<>();
        for (Map.Entry<Date,List<UserSportHistory>> entry:userSportMap.entrySet()) {
            UserEverydaySportSituation userEverydaySportSituation= new UserEverydaySportSituation();
            userEverydaySportSituation.setCollectDate(entry.getKey());
            userEverydaySportSituation.setUserId(userId);
            userEverydaySportSituation.setUserSportHistories(entry.getValue());
            int sumConsumeEnergy = 0;
            for (UserSportHistory userSportHistory:entry.getValue()) {
                sumConsumeEnergy += userSportHistory.getSportTime()*userSportHistory.getSport().getConsumeEnergy();
            }
            userEverydaySportSituation.setSumConsumeEnergy(sumConsumeEnergy);
        userEverydaySportSituations.add(userEverydaySportSituation);

        }
        return userEverydaySportSituations;
    }

}
