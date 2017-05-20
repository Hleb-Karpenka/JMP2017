package com.epam.trainings.mentoring.jpa.repository.relationship.onetomany;

import com.epam.trainings.mentoring.jpa.domain.relationship.onetomany.Daddy;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DaddyRepositoryImpl implements DaddyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Daddy findBy(long id) {
        return entityManager.find(Daddy.class, id);
    }
}
