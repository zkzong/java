package org.example.mysql.product.repo;

import org.example.mysql.product.data.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
}
