package com.epam.trainings.mentoring.jpa.repository.relationship.onetoone;

import com.epam.trainings.mentoring.jpa.domain.relationship.onetoone.Husband;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class HusbandRepositoryImpl implements HusbandRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Husband findBy(long id) {
        return this.entityManager.find(Husband.class, id);
    }
}
