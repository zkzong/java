
package com.zkzong.sj5.mapper;

import com.zkzong.sj5.entity.Order;
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
