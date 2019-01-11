package com.cjlu.o2o.service.impl;

import com.cjlu.o2o.BaseTest;
import com.cjlu.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest {
    @Autowired

    private AreaService areaService;
    @Test

    public  void testGetAreaList(){
        List<Area> areaList = areaService.getAreaList();
        assertEquals("西区",areaList.get(0).getAreaName());


    }
}
