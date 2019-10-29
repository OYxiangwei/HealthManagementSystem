package com.oy.controller;

import com.oy.entity.PaginationObject;
import com.oy.entity.ResultObject;
import com.oy.entity.User;
import com.oy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("add")
    public ResultObject insertUser(User user) {
        System.out.println(user);
        int modifyId = userService.insertUser(user);
        Map<String, Integer> map = new HashMap<>();
        map.put("modifyId", modifyId);
        ResultObject resultObject = new ResultObject(0, "", map);
        return resultObject;
    }

    @GetMapping("get")
    public ResultObject getUserById(@RequestParam int id) {
        User user = userService.getUserById(id);
        ResultObject resultObject = new ResultObject(0, "", user);
        return resultObject;
    }

    @GetMapping("list")
    public ResultObject getAllUser(@RequestParam int pageNum, @RequestParam int pageSize) {
        PaginationObject paginationObj = userService.getAllUser(pageNum, pageSize);
        ResultObject resultObject = new ResultObject(0, "", paginationObj);
        return resultObject;
    }

    @DeleteMapping("delete")
    public ResultObject deleteUser(@RequestParam int id) {
        int modifyId = userService.deleteUser(id);
        Map<String, Integer> map = new HashMap<>();
        map.put("modifyId", modifyId);
        ResultObject resultObject = new ResultObject(0, "", map);
        return resultObject;
    }

    @PutMapping("edit")
    public ResultObject updateUser(User user) {
        int modifyId = userService.updateUser(user);
        Map<String, Integer> map = new HashMap<>();
        map.put("modifyId", modifyId);
        ResultObject resultObject = new ResultObject(0, "", map);
        return resultObject;
    }
}
