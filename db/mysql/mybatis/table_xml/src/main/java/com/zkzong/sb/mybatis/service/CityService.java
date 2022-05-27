package com.zkzong.sb.mybatis.service;

import com.zkzong.sb.mybatis.domain.City;
import org.apache.ibatis.cursor.Cursor;

/**
 * Created by Zong on 2017/6/5.
 */
public interface CityService {
    City findCityByName(String cityName);

    Cursor<City> scan(int limit);
}
