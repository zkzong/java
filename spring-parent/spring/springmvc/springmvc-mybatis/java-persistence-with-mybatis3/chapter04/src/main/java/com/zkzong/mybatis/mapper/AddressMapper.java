package com.zkzong.mybatis.mapper;

import com.zkzong.mybatis.domain.Address;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Zong on 2017/3/11.
 */
public interface AddressMapper {
    @Select("select addr_id as addrId, street, city, state, zip, country from addresses where addr_id=#{id}")
    Address selectAddressById(Integer id);
}
