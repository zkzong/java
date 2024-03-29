package com.example.sj3.jpa.repository;

import com.example.sj3.jpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findDistinctByUserId(Integer userId);

}
