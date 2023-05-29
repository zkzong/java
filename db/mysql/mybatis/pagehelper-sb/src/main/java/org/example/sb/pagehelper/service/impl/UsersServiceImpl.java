package org.example.sb.pagehelper.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.sb.pagehelper.domain.Users;
import org.example.sb.pagehelper.domain.UsersDto;
import org.example.sb.pagehelper.mapper.UsersMapper;
import org.example.sb.pagehelper.service.UsersService;
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
    public int insert(Users users) {
        return usersMapper.insert(users);
    }

    @Override
    public List<Users> list() {
        return usersMapper.list();
    }

    @Override
    public PageInfo<Users> page(UsersDto param) {
        if (param == null) {
            PageHelper.startPage(10, 5);
        } else {
            PageHelper.startPage(param.getPageNum(), param.getPageSize());
        }

        // 查找所有
        //PageHelper.startPage(1, 0);
        List<Users> allUsers = usersMapper.list();
        PageInfo<Users> page = new PageInfo<>(allUsers);
        return page;

        // list()为该类中list方法
        //return PageHelper.startPage(param.getPageNum(), param.getPageSize())
        //        .doSelectPageInfo(() -> list());
    }

}
