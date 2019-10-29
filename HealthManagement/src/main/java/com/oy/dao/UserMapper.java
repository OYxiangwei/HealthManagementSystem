package com.oy.dao;

import com.oy.entity.User;

import java.util.List;

public interface UserMapper {

    User getById(int id);

    List<User> getAll();

    int insert(User user);

    int update(User user);

    int delete(int id);

}
