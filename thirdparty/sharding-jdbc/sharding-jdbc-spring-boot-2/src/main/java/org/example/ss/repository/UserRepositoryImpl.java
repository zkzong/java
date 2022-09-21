package org.example.ss.repository;

import org.example.ss.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createTableIfNotExists() {
        throw new UnsupportedOperationException("createTableIfNotExists for JPA");
    }

    @Override
    public void dropTable() {
        throw new UnsupportedOperationException("dropTable for JPA");
    }

    @Override
    public void truncateTable() {
        throw new UnsupportedOperationException("truncateTable for JPA");
    }

    @Override
    public Long insert(final User entity) {
        entityManager.persist(entity);
        return null;
    }

    @Override
    public void delete(final Long id) {
        Query query = entityManager.createQuery("DELETE FROM UserEntiy o WHERE o.userId = ?1");
        query.setParameter(1, id.intValue());
        query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> selectAll() {
        return (List<User>) entityManager.createQuery("SELECT o FROM UserEntiy o").getResultList();
    }
}
