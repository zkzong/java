package com.example.sb.redis.dao;

import com.example.sb.redis.domain.City;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Zong on 2017/6/5.
 */
@Mapper
public interface CityDao {
    @Select("select * from city where city_name = #{cityName}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description")
    })
    City findByName(@Param("cityName") String cityName);

    @Select("select * from city where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description")
    })
    City findById(@Param("id") Long id);

    @Insert("insert into city(province_id, city_name, description) values (#{provinceId}, #{cityName}, #{description})")
    Long saveCity(City city);

    @Update("update city set city_name = #{cityName} where id = #{id}")
    Long updateCity(City city);

    @Delete("delete from city where id = #{id}")
    Long deleteCity(Long id);
}
