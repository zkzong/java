package com.example.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mp.entity.TUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: zkzong
 * @Date: 2018.9.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PageTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testPage() {
        System.err.println("----- baseMapper 自带分页 ------");
        Page<TUser> page = new Page<>(1, 1);
        IPage<TUser> userIPage = userMapper.selectPage(page, new QueryWrapper<TUser>());
        Assert.assertSame(page, userIPage);
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        System.out.println(userIPage.getRecords());
    }
}
