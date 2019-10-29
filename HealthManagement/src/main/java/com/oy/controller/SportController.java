package com.oy.controller;

import com.oy.entity.PaginationObject;
import com.oy.entity.ResultObject;
import com.oy.entity.Sport;
import com.oy.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("api/v1/sport")
public class SportController {
    @Autowired
    private SportService sportService;
    @GetMapping("get")
    public ResultObject getSportById(@RequestParam int id) {
        Sport sport = sportService.getSportById(id);
        return new ResultObject(0, "success", sport);
    }
    @PostMapping("add")
    public ResultObject insertSport(Sport sport){
        int modifyId = sportService.insertSport(sport);
        Map<String,Integer> map = new HashMap<>();
        map.put("modifyId",modifyId);
        return new ResultObject(0,"success",map);
    }
    @GetMapping("list")
    public ResultObject getAllSport(@RequestParam int pageNum,@RequestParam int pageSize){
       PaginationObject paginationObject = sportService.getAllSport(pageNum,pageSize);
        return  new ResultObject(0,"success",paginationObject);
    }
    @DeleteMapping("delete")
    public ResultObject deleteSport(@RequestParam int id){
        int modifyId = sportService.deleteSport(id);
        Map<String,Integer> map = new HashMap<>();
        map.put("modifyId",modifyId);
        return new ResultObject(0,"success",map);
    }
    @PutMapping("edit")
    public ResultObject updateSport(Sport sport){
        int modifyId = sportService.updateSport(sport);
        Map<String,Integer> map = new HashMap<>();
        map.put("modifyId",modifyId);
        return new ResultObject(0,"success",map);
    }
}

