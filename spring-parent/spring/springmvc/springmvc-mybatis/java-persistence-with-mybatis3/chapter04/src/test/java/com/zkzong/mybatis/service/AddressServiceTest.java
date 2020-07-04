package com.zkzong.mybatis.service;

import com.zkzong.mybatis.domain.Address;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Zong on 2017/3/11.
 */
public class AddressServiceTest {
    private static AddressService addressService;

    @BeforeClass
    public static void setUp() throws Exception {
        addressService = new AddressService();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        addressService = null;
    }

    @Test
    public void findAddressById() throws Exception {
        Address address = addressService.findAddressById(1);
        System.out.println(address);
    }

}