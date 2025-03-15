package com.example.sb.pagehelper.service;

import com.example.sb.pagehelper.domain.Users;
import com.example.sb.pagehelper.domain.UsersDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by Zong on 2017/6/1.
 */
public interface UsersService {

    int insert(Users users);

    List<Users> list();

    PageInfo<Users> page(UsersDto param);

}
