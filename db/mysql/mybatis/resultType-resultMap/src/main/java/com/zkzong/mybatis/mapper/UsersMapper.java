package com.zkzong.mybatis.mapper;

import com.zkzong.mybatis.domain.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Zong on 2017/6/1.
 */
@Mapper
public interface UsersMapper {

    List<String> getUserName();

    List<Users> getUsersMap();

    List<Users> getUsersType();

}
