package org.example.mysql.customer.repo;

import org.example.mysql.customer.data.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {
}
