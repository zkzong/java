package com.zkzong.sb.basic.service.impl;

import com.zkzong.sb.basic.dao.CityDao;
import com.zkzong.sb.basic.domain.City;
import com.zkzong.sb.basic.service.CityService;
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
