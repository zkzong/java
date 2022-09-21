package org.example.sj3.jpa.repository;

import org.example.sj3.jpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findDistinctByUserId(Integer userId);

}
