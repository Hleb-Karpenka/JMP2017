package com.epam.trainings.mentoring.jpa.repository.inheritance.tableperclass;

import com.epam.trainings.mentoring.jpa.domain.inheritance.tableperclass.ClassicSandwich;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClassicSandwichRepositoryImpl implements ClassicSandwichRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ClassicSandwich> findAll() {
        return this.entityManager.createQuery("SELECT cs FROM ClassicSandwich cs", ClassicSandwich.class)
                .getResultList();
    }
}
