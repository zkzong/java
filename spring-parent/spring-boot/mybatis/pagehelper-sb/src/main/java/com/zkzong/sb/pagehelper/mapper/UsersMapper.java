package com.zkzong.sb.pagehelper.mapper;

import com.zkzong.sb.pagehelper.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Zong on 2017/6/1.
 */
@Mapper
public interface UsersMapper {
    @Select("select * from users")
    List<Users> getAllUsers();
}
