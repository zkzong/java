package com.zkzong.sb.basic.service;

import com.zkzong.sb.basic.domain.City;

/**
 * Created by Zong on 2017/6/5.
 */
public interface CityService {
    City findCityByName(String cityName);
}
