
package org.example.sj4.repository;

import org.example.sj4.entity.Order;
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

    Order selectByOrderId();

    List<Order> selectRange();

    List<Order> selectgt();

    List<Order> selectlt();
}
