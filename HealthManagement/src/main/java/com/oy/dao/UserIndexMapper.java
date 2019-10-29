package com.oy.dao;

import com.oy.entity.UserIndex;

import java.util.List;

public interface UserIndexMapper {
    List<UserIndex> getById(int userId);
}
