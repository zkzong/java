package com.zkzong.mybatis.pagehelper.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkzong.mybatis.pagehelper.domain.Users;
import com.zkzong.mybatis.pagehelper.mapper.UsersMapper;
import com.zkzong.mybatis.pagehelper.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zong on 17-5-31.
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users findUsersById(int id) {
        logger.debug("findUsersById : " + id);
        return usersMapper.findUsersById(id);
    }

    @Override
    public List<Users> getAllUsers() {
        logger.debug("getAllUsers");
        return usersMapper.getAllUsers();
    }

    @Override
    public PageInfo<Users> getUsersByPage() {
        PageHelper.startPage(1, 5);
        // 查找所有记录
//        PageHelper.startPage(1, 0);
        List<Users> allUsers = usersMapper.getAllUsers();
        PageInfo<Users> page = new PageInfo<Users>(allUsers);
        return page;
    }
}
