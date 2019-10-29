package com.oy.controller;

import com.oy.entity.Food;
import com.oy.entity.PaginationObject;
import com.oy.entity.ResultObject;
import com.oy.entity.User;
import com.oy.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("api/v1/food")
public class FoodController {
    @Autowired
    private FoodService foodService;
    @GetMapping("get")
    public ResultObject getFoodById(@RequestParam int id){
        Food food = foodService.getFoodById(id);
        return new ResultObject(0,"success",food);
    }

    @PostMapping("add")
    public ResultObject insertFood(Food food){
        int modifyId =  foodService.insertFood(food);
        Map<String,Integer> map = new HashMap<>();
        map.put("modifyId",modifyId);
        return new ResultObject(0,"success",map);
    }
    @GetMapping("list")
    public ResultObject getAllFood(@RequestParam int pageNum,@RequestParam int pageSize){
        PaginationObject paginationObject= foodService.getAllFood(pageNum,pageSize);
        return new ResultObject(0,"success",paginationObject);
    }

    @DeleteMapping("delete")
    public ResultObject deleteUser(@RequestParam int id){
        int modifyId = foodService.deleteFood(id);
        Map<String,Integer> map = new HashMap<>();
        map.put("modifyId",modifyId);
        return new ResultObject(0,"success",map);
    }
    @PutMapping("edit")
    public ResultObject updateUser(Food food){
       int modifyId = foodService.updateFood(food);
       Map<String,Integer> map = new HashMap<>();
       map.put("modifyId",modifyId);
       return new ResultObject(0,"success",map);
    }

}
