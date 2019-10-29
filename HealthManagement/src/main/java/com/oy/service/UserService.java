package com.oy.service;

import com.oy.entity.PaginationObject;
import com.oy.entity.User;

public interface UserService {
    public int insertUser(User user);

    public User getUserById(int id);

    public PaginationObject getAllUser(int pageNum, int pageSize);

    public int updateUser(User user);

    public int deleteUser(int id);
}
