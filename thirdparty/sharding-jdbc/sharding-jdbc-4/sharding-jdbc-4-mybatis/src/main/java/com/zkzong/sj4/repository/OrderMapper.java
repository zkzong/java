
package com.zkzong.sj4.repository;

import com.zkzong.sj4.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    void createTableIfNotExists();

    void truncateTable();

    void dropTable();

    int insert(Order order);

    void delete(Long orderId);

    List<Order> selectAll();

    List<Order> selectRange();
}
