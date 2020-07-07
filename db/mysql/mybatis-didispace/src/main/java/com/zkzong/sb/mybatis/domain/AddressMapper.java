package com.zkzong.sb.mybatis.domain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Zong on 2017/4/25.
 */
@Mapper
public interface AddressMapper {

    @Select("select * from address where id = #{id}")
    Address findById(Integer id);

    @Insert("insert into address(province, city, user_id) values(#{province}, #{city}, #{userId})")
    int insert(@Param("province") String province, @Param("city") String city, @Param("userId") Integer userId);

}
