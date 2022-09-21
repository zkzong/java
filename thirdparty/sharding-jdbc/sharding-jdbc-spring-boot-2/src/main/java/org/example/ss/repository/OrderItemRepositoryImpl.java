package org.example.ss.repository;

import org.example.ss.entity.OrderItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OrderItemRepositoryImpl implements OrderItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createTableIfNotExists() {
        throw new UnsupportedOperationException("createTableIfNotExists for JPA");
    }

    @Override
    public void truncateTable() {
        throw new UnsupportedOperationException("truncateTable for JPA");
    }

    @Override
    public void dropTable() {
        throw new UnsupportedOperationException("dropTable for JPA");
    }

    @Override
    public Long insert(final OrderItem orderItem) {
        entityManager.persist(orderItem);
        return orderItem.getOrderItemId();
    }

    @Override
    public void delete(final Long orderItemId) {
        Query query = entityManager.createQuery("DELETE FROM OrderItemEntity i WHERE i.orderItemId = ?1 AND i.userId = 51");
        query.setParameter(1, orderItemId);
        query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<OrderItem> selectAll() {
        return (List<OrderItem>) entityManager.createQuery("SELECT i FROM OrderEntity o, OrderItemEntity i WHERE o.orderId = i.orderId").getResultList();
    }
}
