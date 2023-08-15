package com.example.sj3.mybatis.mapper;

import com.example.sj3.mybatis.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(Order order);

    void delete(Long orderId);

    void dropTable();

    List<Order> findInSet(String status);
}
