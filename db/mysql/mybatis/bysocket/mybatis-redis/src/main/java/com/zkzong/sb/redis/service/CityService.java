package com.zkzong.sb.redis.service;

import com.zkzong.sb.redis.domain.City;

/**
 * Created by Zong on 2017/6/6.
 */
public interface CityService {
    City findCityById(Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
