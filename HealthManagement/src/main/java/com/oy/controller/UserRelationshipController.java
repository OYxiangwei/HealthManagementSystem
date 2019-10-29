package com.oy.controller;

import com.oy.entity.ResultObject;
import com.oy.entity.UserRelationship;
import com.oy.service.UserRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api/v1/relationship")
public class UserRelationshipController {
    @Autowired
    private UserRelationshipService userRelationshipService;
    @RequestMapping("get")
    public ResultObject getRelationship(@RequestParam int id){
       UserRelationship  userRelationship = userRelationshipService.getRelationship(id);
        return new ResultObject(0,"success",userRelationship);
    }
}
