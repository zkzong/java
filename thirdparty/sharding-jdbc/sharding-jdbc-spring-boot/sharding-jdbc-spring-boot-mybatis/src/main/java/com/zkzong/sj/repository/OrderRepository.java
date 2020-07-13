package com.zkzong.sj.repository;

import com.zkzong.sj.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderRepository {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(Order order);

    void delete(Long orderId);

    void dropTable();
}
