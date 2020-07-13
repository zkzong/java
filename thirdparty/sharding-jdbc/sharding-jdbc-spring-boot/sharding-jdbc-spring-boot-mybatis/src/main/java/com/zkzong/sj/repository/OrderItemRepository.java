package com.zkzong.sj.repository;

import com.zkzong.sj.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderItemRepository {

    void createIfNotExistsTable();

    void truncateTable();

    Long insert(OrderItem orderItem);

    void delete(Long orderItemId);

    List<OrderItem> selectAll();

    void dropTable();
}
