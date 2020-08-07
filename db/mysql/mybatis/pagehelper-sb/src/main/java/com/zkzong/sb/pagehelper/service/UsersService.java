package com.zkzong.sb.pagehelper.service;

import com.github.pagehelper.PageInfo;
import com.zkzong.sb.pagehelper.domain.Users;

import java.util.List;

/**
 * Created by Zong on 2017/6/1.
 */
public interface UsersService {
    List<Users> getAllUsers();

    PageInfo<Users> getUsersByPage();
}
