package com.oy.controller;

import com.oy.dao.UserFoodHistoryMapper;
import com.oy.entity.ResultObject;
import com.oy.entity.UserEverydayFoodSituation;
import com.oy.entity.UserFoodHistory;
import com.oy.service.UserFoodHistoryService;
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
@RequestMapping("/api/v1/user_food_history")
public class UserFoodHistoryController {
    @Autowired
    private UserFoodHistoryService userFoodHistoryService;
    @GetMapping("get")
    public ResultObject getAllUserFoodHistory(@RequestParam int userId){
       List<UserEverydayFoodSituation> userEverydayFoodSituations = userFoodHistoryService.getAllUserFoodHistory(userId);
       return new ResultObject(0,"success",userEverydayFoodSituations);
    }

    @PostMapping("add")
    public ResultObject insertUserFoodHistory(@RequestParam UserFoodHistory userFoodHistory){
      int modifyId =  userFoodHistoryService.insertUserFoodHistory(userFoodHistory);
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
}
