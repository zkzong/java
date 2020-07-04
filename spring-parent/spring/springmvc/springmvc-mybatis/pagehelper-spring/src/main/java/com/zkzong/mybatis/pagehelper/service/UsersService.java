package com.zkzong.mybatis.pagehelper.service;

import com.github.pagehelper.PageInfo;
import com.zkzong.mybatis.pagehelper.domain.Users;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zong on 2017/5/31.
 */
@Service
public interface UsersService {

    Users findUsersById(int id);

    List<Users> getAllUsers();

    PageInfo<Users> getUsersByPage();
}
