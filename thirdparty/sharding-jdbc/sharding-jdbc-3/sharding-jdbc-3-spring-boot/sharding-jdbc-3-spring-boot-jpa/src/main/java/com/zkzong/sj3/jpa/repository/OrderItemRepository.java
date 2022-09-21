package org.example.sj3.jpa.repository;

import org.example.sj3.jpa.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
