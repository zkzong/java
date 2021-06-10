package com.zkzong.sb.pagehelper.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkzong.sb.pagehelper.domain.Users;
import com.zkzong.sb.pagehelper.domain.UsersDto;
import com.zkzong.sb.pagehelper.mapper.UsersMapper;
import com.zkzong.sb.pagehelper.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zong on 2017/6/1.
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> getAllUsers() {
        return usersMapper.getAllUsers();
    }

    @Override
    public PageInfo<Users> getUsersByPage() {
        PageHelper.startPage(10, 5);
        // 查找所有
//        PageHelper.startPage(1, 0);
        List<Users> allUsers = usersMapper.getAllUsers();
        PageInfo<Users> page = new PageInfo<Users>(allUsers);
        return page;
    }

    @Override
    public PageInfo<Users> page(UsersDto param) {
        return PageHelper.startPage(param.getPageNum(), param.getPageSize())
                .doSelectPageInfo(() -> list(param));
    }

    @Override
    public List<Users> list(UsersDto param) {
        return usersMapper.getAllUsers();
    }

}
