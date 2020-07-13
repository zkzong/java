package com.zkzong.sj.repository;

import com.zkzong.sj.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
