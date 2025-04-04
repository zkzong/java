package com.example.sb.pagehelper.mapper;

import com.example.sb.pagehelper.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Zong on 2017/6/1.
 */
@Mapper
public interface UsersMapper {

    @Insert("insert into users(name, age) values(#{name}, #{age})")
    int insert(Users users);

    //@Select("select * from users")
    List<Users> list();

    //@Select("select count(*) from users")
    Long list_COUNT();
}
