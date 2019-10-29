package com.oy.service;

import com.oy.entity.Food;
import com.oy.entity.PaginationObject;

public interface FoodService {
    public Food getFoodById(int id);

    public int insertFood(Food food);

    public PaginationObject getAllFood(int pageNum,int pageSize);

    public int updateFood(Food food);

    public int deleteFood(int id);
}
