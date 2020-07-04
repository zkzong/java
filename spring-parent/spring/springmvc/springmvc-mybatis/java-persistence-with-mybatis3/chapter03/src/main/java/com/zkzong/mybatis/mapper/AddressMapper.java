package com.zkzong.mybatis.mapper;

import com.zkzong.mybatis.domain.Address;

/**
 * Created by Zong on 2017/3/11.
 */
public interface AddressMapper {
    Address selectAddressById(Integer id);
}
