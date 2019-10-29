package com.oy.service.serviceimpl;

import com.oy.dao.UserFoodHistoryMapper;
import com.oy.dao.UserIndexMapper;
import com.oy.dao.UserSportHistoryMapper;
import com.oy.entity.EnergyDate;
import com.oy.entity.UserIndex;
import com.oy.entity.UserRelationship;
import com.oy.service.UserRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserRelationshipServiceImpl implements UserRelationshipService {
    @Autowired
    private UserIndexMapper userIndexMapper;
    @Autowired
    private UserFoodHistoryMapper userFoodHistoryMapper;
    @Autowired
    private UserSportHistoryMapper userSportHistoryMapper;

    @Override
    public UserRelationship getRelationship(int userId) {
        UserRelationship userRelationship = new UserRelationship();
        List<EnergyDate> foodEnergy = userFoodHistoryMapper.getSumFoodEnergy(userId);
        List<EnergyDate> sportEnergy= userSportHistoryMapper.getSumConsumeEnergy(userId);
        List<UserIndex> userIndices = userIndexMapper.getById(userId);
        Map<Integer,List<UserIndex>> userIndexes = new HashMap<>();
        for (UserIndex userIndex:userIndices) {
            int indexType = userIndex.getIndexType();
            if(userIndexes.containsKey(indexType)){
            List<UserIndex> userIndices1 = userIndexes.get(indexType);
            userIndices1.add(userIndex);
            }else {
            List<UserIndex> userIndices1 = new ArrayList<>();
            userIndices1.add(userIndex);
            userIndexes.put(indexType,userIndices1);
            }
        }
        userRelationship.setFoodEnergies(foodEnergy);
        userRelationship.setSportEnergies(sportEnergy);
        userRelationship.setUserIndexes(userIndexes);
        userRelationship.setUserId(userId);
        return  userRelationship;

    }
}
