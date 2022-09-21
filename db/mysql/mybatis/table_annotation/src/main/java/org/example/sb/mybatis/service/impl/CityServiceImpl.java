package org.example.sb.mybatis.service.impl;

import org.example.sb.mybatis.domain.City;
import org.example.sb.mybatis.mapper.CityDao;
import org.example.sb.mybatis.service.CityService;
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
}