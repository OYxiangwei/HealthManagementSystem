package com.oy.dao;

import com.oy.entity.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {
    int insert(Food food);

    Food getById(int id);

    List<Food> getAll();

    int update(Food food);

    int delete(int id);
}
