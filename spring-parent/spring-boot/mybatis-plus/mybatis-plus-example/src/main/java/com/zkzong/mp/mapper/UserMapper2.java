package com.zkzong.mp.mapper;

import com.zkzong.mp.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: zong
 * @Date: 2019.2.16
 */
@Mapper
public interface UserMapper2 {
    @Select("select id, user_name userName, age, email from t_user where id = #{id}")
    TUser getUserById(Integer id);
}
