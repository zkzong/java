package com.example.ss.repository;

import com.example.ss.entity.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AddressRepositoryImpl implements AddressRepository {

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
    public Long insert(final Address entity) {
        entityManager.persist(entity);
        return entity.getAddressId();
    }

    @Override
    public void delete(final Long addressCode) {
        Query query = entityManager.createQuery("DELETE FROM AddressEntity i WHERE i.addressCode = ?1");
        query.setParameter(1, addressCode);
        query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Address> selectAll() {
        return (List<Address>) entityManager.createQuery("SELECT i FROM AddressEntity i").getResultList();
    }
}
