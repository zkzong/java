package org.example.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.mp.entity.TUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: zkzong
 * @Date: 2021.4.21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void query() {
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(TUser::getUserName, "Tom");
        TUser tUser = userMapper.selectOne(wrapper);
        System.out.println(tUser);
    }

}
