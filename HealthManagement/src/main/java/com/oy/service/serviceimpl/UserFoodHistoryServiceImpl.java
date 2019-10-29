package com.oy.service.serviceimpl;

import com.oy.dao.UserFoodHistoryMapper;
import com.oy.entity.UserEverydayFoodSituation;
import com.oy.entity.UserFoodHistory;
import com.oy.service.UserFoodHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class UserFoodHistoryServiceImpl implements UserFoodHistoryService {
    @Autowired
    private UserFoodHistoryMapper userFoodHistoryMapper;

    @Override
    public int insertUserFoodHistory(UserFoodHistory userFoodHistory) {
        return userFoodHistoryMapper.insert(userFoodHistory);
    }

    @Override
    public List<UserEverydayFoodSituation> getAllUserFoodHistory(int userId) {
            List<UserFoodHistory> userFoodHistories = userFoodHistoryMapper.getAll(userId);
            Map<Date,List<UserFoodHistory>> userFoodMap = new TreeMap<Date, List<UserFoodHistory>>();
        for (UserFoodHistory userFoodHistory:userFoodHistories) {
            Date cDate =userFoodHistory.getCollectDate();
            if(userFoodMap.containsKey(cDate)){
                List<UserFoodHistory> userFoodList=userFoodMap.get(cDate);
                userFoodList.add(userFoodHistory);
            }else {
                List<UserFoodHistory> userFoodList= new ArrayList<UserFoodHistory>();
                userFoodList.add(userFoodHistory);
                userFoodMap.put(cDate,userFoodList);
            }
        }
        List<UserEverydayFoodSituation> userEverydayFoodSituations = new ArrayList<>();
        for (Map.Entry<Date,List<UserFoodHistory>> entry:userFoodMap.entrySet()) {
            UserEverydayFoodSituation userEverydayFoodSituation = new UserEverydayFoodSituation();
            userEverydayFoodSituation.setUserId(userId);
            userEverydayFoodSituation.setCollectDate(entry.getKey());
            userEverydayFoodSituation.setUserFoodHistories(entry.getValue());
            int sumFoodEnergy = 0;
            for (UserFoodHistory userFoodHistory:entry.getValue()) {
                sumFoodEnergy += userFoodHistory.getFoodQuantity() * userFoodHistory.getFood().getFoodEnergy() / 500;
            }
            userEverydayFoodSituation.setSumFoodEnergy(sumFoodEnergy);
            userEverydayFoodSituations.add(userEverydayFoodSituation);
        }
        return userEverydayFoodSituations;
    }
}
