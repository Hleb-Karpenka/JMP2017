package com.epam.trainings.mentoring.jpa.repository.relationship.onetomany;

import com.epam.trainings.mentoring.jpa.domain.relationship.onetomany.Kid;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class KidRepositoryImpl implements KidRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Kid> findAll() {
        return this.entityManager.createQuery("SELECT h FROM Kid h", Kid.class)
                .getResultList();
    }
}
