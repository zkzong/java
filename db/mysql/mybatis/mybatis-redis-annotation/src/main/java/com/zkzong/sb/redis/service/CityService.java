package com.zkzong.sb.redis.service;

import com.zkzong.sb.redis.domain.City;

/**
 * Created by Zong on 2017/6/5.
 */
public interface CityService {
    City findCityByName(String cityName);

    City findCityById(Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
