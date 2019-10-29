package com.oy.controller;


import com.oy.entity.ResultObject;
import com.oy.entity.UserEverydaySportSituation;
import com.oy.entity.UserSportHistory;
import com.oy.service.UserSportHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/v1/user_sport_history")
public class UserSportHistoryController {
    @Autowired
    private UserSportHistoryService userSportHistoryService;

    @PostMapping("add")
    public ResultObject insertUserSportHistory(@RequestParam UserSportHistory userSportHistory){
        int modifyId = userSportHistoryService.insertUserSportHistory(userSportHistory);
        Map<String,Integer> map = new HashMap<>();
        map.put("modifyId",modifyId);
        ResultObject resultObject = new ResultObject();
        resultObject.setResult(map);
        if(modifyId==1){
        resultObject.setCode(0);
        resultObject.setMsg("success");
        }else {
            resultObject.setCode(-1);
            resultObject.setMsg("fail");
        }
        return resultObject;
    }

    @GetMapping("get")
    public ResultObject getAllUserDrugHistory(@RequestParam int userId){
           List<UserEverydaySportSituation>  userEverydaySportSituations =userSportHistoryService.getAllUserSportHistory(userId);
           return new ResultObject(0,"success",userEverydaySportSituations);
    }
}
