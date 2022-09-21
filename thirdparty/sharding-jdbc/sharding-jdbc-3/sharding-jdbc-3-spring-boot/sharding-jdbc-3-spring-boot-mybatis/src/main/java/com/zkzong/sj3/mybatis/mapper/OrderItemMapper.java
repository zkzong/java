package org.example.sj3.mybatis.mapper;

import org.example.sj3.mybatis.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderItemMapper {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(OrderItem orderItem);

    void delete(Long orderItemId);

    List<OrderItem> selectAll();

    void dropTable();
}
