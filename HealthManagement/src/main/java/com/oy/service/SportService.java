package com.oy.service;

import com.oy.entity.PaginationObject;
import com.oy.entity.Sport;

public interface SportService {
    public Sport getSportById(int id);

    public int insertSport(Sport sport);

    public PaginationObject getAllSport(int pageNum, int pageSize);

    public int updateSport(Sport sport);

    public int deleteSport(int id);
}
