package com.example.sb.redis.service;

import com.example.sb.redis.domain.City;

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
