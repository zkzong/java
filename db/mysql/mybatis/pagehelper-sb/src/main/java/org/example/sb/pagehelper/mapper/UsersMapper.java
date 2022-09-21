package org.example.sb.pagehelper.mapper;

import org.example.sb.pagehelper.domain.Users;
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
