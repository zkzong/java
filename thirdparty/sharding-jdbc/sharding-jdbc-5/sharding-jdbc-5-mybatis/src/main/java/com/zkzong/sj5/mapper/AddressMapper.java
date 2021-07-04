
package com.zkzong.sj5.mapper;

import com.zkzong.sj5.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    void createTableIfNotExists();

    void truncateTable();

    void dropTable();

    int insert(Address address);

    void delete(Long addressId);

    List<Address> selectAll();
}
