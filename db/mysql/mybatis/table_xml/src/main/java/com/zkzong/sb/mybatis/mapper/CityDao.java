package com.zkzong.sb.mybatis.mapper;

import com.zkzong.sb.mybatis.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

/**
 * Created by Zong on 2017/6/5.
 */
@Mapper
public interface CityDao {
    City findByName(@Param("cityName") String cityName);

    Cursor<City> scan(@Param("limit") int limit);
}
