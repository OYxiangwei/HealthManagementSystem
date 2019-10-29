package com.oy.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oy.dao.SportMapper;
import com.oy.entity.PaginationObject;
import com.oy.entity.Sport;
import com.oy.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportServiceImpl implements SportService {
    @Autowired
    private SportMapper sportMapper;

    @Override
    public Sport getSportById(int id) {
        return sportMapper.getById(id);
    }

    @Override
    public int insertSport(Sport sport) {
        return sportMapper.insert(sport);
    }

    @Override
    public PaginationObject getAllSport(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Sport> sports = sportMapper.getAll();
        PageInfo<Sport> pageInfo = new PageInfo(sports);
        long total = pageInfo.getTotal();
        return new PaginationObject(sports,pageNum,pageSize,total);
    }

    @Override
    public int updateSport(Sport sport) {
        return sportMapper.update(sport);
    }

    @Override
    public int deleteSport(int id) {
        return sportMapper.delete(id);
    }
}
