package com.oy.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oy.dao.FoodMapper;
import com.oy.entity.Food;
import com.oy.entity.PaginationObject;
import com.oy.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public Food getFoodById(int id) {
        return foodMapper.getById(id);
    }

    @Override
    public int insertFood(Food food) {
        return foodMapper.insert(food);
    }

    @Override
    public PaginationObject getAllFood(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Food> foods = foodMapper.getAll();
        PageInfo<Food> pageInfo = new PageInfo<Food>(foods);
        long total = pageInfo.getTotal();
        return new PaginationObject(foods,pageNum,pageSize,total);
    }

    @Override
    public int updateFood(Food food) {
        return foodMapper.update(food);
    }

    @Override
    public int deleteFood(int id) {
        return foodMapper.delete(id);
    }
}
