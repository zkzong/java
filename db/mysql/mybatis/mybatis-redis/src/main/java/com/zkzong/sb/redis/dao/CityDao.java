package com.zkzong.sb.redis.dao;

import com.zkzong.sb.redis.domain.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Zong on 2017/6/6.
 */
public interface CityDao {
    List<City> findAllCity();

    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);

}
