package com.zkzong.sj3.jpa.repository;

import com.zkzong.sj3.jpa.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
