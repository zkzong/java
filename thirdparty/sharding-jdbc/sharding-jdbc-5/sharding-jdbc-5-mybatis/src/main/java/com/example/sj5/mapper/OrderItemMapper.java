
package com.example.sj5.mapper;

import com.example.sj5.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderItemMapper {
    void createTableIfNotExists();

    void truncateTable();

    void dropTable();

    int insert(OrderItem orderItem);

    void delete(Long orderId);

    List<OrderItem> selectAll();

    List<OrderItem> selectRange();
}
