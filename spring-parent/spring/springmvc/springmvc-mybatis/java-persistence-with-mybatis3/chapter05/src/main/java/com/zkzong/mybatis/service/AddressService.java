package com.zkzong.mybatis.service;

import com.zkzong.mybatis.domain.Address;
import com.zkzong.mybatis.mapper.AddressMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Zong on 2017/3/11.
 */
@Service
@Transactional
public class AddressService {
//    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AddressMapper addressMapper;

    public Address findAddressById(int addrId) {
        return addressMapper.selectAddressById(addrId);
    }

}
