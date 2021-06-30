
package com.zkzong.sj4.repository;

import com.zkzong.sj4.entity.Order;
import com.zkzong.sj4.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderItemMapper {
    void createTableIfNotExists();

    void truncateTable();

    void dropTable();

    int insert(OrderItem orderItem);

    void delete(Long orderId);

    List<Order> selectAll();

    List<Order> selectRange();
}
