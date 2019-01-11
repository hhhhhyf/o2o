package com.cjlu.o2o.service.impl;

import com.cjlu.o2o.dao.AreaDao;
import com.cjlu.o2o.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
