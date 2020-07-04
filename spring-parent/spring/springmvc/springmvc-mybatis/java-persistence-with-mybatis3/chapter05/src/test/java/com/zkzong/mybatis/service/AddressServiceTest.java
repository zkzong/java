package com.zkzong.mybatis.service;

import com.zkzong.mybatis.domain.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Zong on 2017/3/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AddressServiceTest {
    @Autowired
    private AddressService addressService;

    @Test
    public void findAddressById() throws Exception {
        Address address = addressService.findAddressById(1);
        System.out.println(address);
    }

}