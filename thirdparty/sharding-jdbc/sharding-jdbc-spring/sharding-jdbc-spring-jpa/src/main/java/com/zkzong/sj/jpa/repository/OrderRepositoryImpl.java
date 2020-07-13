package com.zkzong.sj.jpa.repository;

import com.zkzong.sj.jpa.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Long insert(final Order order) {
        entityManager.persist(order);
        return order.getOrderId();
    }
    
    @Override
    public void delete(final Long orderId) {
        Query query = entityManager.createQuery("DELETE FROM Order o WHERE o.orderId = ?1 AND o.userId = 51");
        query.setParameter(1, orderId);
        query.executeUpdate();
    }
}
