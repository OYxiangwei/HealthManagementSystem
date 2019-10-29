package com.oy.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oy.dao.UserMapper;
import com.oy.entity.PaginationObject;
import com.oy.entity.User;
import com.oy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        user.setCreateTime(new Date(new java.util.Date().getTime()));
        return userMapper.insert(user);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getById(id);
    }

    @Override
    public PaginationObject getAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.getAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        long total = pageInfo.getTotal();
        return new PaginationObject(users,pageNum,pageSize,total);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.update(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.delete(id);
    }
}
