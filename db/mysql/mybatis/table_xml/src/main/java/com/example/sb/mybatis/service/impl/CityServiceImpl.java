package com.example.sb.mybatis.service.impl;

import com.example.sb.mybatis.domain.City;
import com.example.sb.mybatis.mapper.CityDao;
import com.example.sb.mybatis.service.CityService;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zong on 2017/6/5.
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;

    @Override
    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

    @Override
    public Cursor<City> scan(int limit) {
        return cityDao.scan(limit);
    }
}
