package com.example.sb.mybatis.service;

import com.example.sb.mybatis.domain.City;

/**
 * Created by Zong on 2017/6/5.
 */
public interface CityService {
    City findCityByName(String cityName);
}
