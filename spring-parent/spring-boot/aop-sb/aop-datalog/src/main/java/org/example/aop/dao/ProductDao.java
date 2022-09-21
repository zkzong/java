package org.example.aop.dao;

import org.example.aop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}
