package com.mj.mjdemoapp.dao;

import com.mj.mjdemoapp.entities.Officer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaOfficerDao implements OfficerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Officer save(Officer officer) {
        entityManager.persist(officer);
        return officer;
    }

    @Override
    public Optional<Officer> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Officer.class, id));
    }

    @Override
    public List<Officer> findAll() {
        return entityManager.createQuery("SELECT o from Officer o", Officer.class)
                .getResultList();
    }

    @Override
    public long count() {
        return entityManager.createQuery("SELECT count(o.id) from Officer o", Long.class)
                .getSingleResult();
    }

    @Override
    public void delete(Officer officer) {
        entityManager.remove(officer);
    }

    @Override
    public boolean existsById(Integer id) {
        Long count = entityManager.createQuery("SELECT count(o.id) from Officer o where id = :id", Long.class)
                .setParameter("id", id)
                .getSingleResult();
        return count > 0;

    }
}
