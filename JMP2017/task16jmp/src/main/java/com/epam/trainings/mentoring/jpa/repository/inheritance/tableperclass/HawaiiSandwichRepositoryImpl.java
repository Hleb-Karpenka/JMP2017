package com.epam.trainings.mentoring.jpa.repository.inheritance.tableperclass;

import com.epam.trainings.mentoring.jpa.domain.inheritance.tableperclass.HawaiiSandwich;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HawaiiSandwichRepositoryImpl implements HawaiiSandwichRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HawaiiSandwich> findAll() {
        return this.entityManager.createQuery("SELECT hs FROM HawaiiSandwich hs", HawaiiSandwich.class)
                .getResultList();
    }
}
