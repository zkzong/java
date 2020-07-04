package com.zkzong.sb.basic.dao;

import com.zkzong.sb.basic.domain.City;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Zong on 2017/6/5.
 */
public interface CityDao {
    City findByName(@Param("cityName") String cityName);
}
