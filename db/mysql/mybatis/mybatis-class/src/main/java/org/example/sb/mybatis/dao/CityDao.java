package com.example.sb.mybatis.dao;

import com.example.sb.mybatis.domain.City;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Zong on 2017/6/5.
 */
public interface CityDao {
    City findByName(@Param("cityName") String cityName);
}
