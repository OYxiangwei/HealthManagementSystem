package com.oy.dao;

import com.oy.entity.Sport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SportMapper {
    int insert(Sport drug);

    Sport getById(int id);

    List<Sport> getAll();

    int update(Sport drug);

    int delete(int id);

}
