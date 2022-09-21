package org.example.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.mp.entity.TUser;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: zkzong
 * @Date: 2018.9.8
 */
public interface UserMapper extends BaseMapper<TUser> {
    @Select("select id, user_name userName, age, email from t_user where id = #{id}")
    TUser getUserById(Integer id);

    TUser getById(Integer id);
}
