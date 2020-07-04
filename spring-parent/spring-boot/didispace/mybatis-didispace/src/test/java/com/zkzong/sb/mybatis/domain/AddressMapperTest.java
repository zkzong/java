package com.zkzong.sb.mybatis.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Zong on 2017/4/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class AddressMapperTest {
    @Autowired
    private AddressMapper addressMapper;

    @Test
    @Rollback
    public void findById() throws Exception {
        addressMapper.insert("河南", "许昌", 1);
//        Address a = addressMapper.findById(1);
//        Assert.assertEquals(20, u.getAge().intValue());
    }
}