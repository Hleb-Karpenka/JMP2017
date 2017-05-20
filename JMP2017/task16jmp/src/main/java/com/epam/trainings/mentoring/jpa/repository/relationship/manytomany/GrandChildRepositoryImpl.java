package com.epam.trainings.mentoring.jpa.repository.relationship.manytomany;

import com.epam.trainings.mentoring.jpa.domain.relationship.manytomany.GrandChild;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GrandChildRepositoryImpl implements GrandChildRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<GrandChild> findAll() {
        return this.entityManager.createQuery("SELECT gc FROM GrandChild gc", GrandChild.class)
                .getResultList();
    }
}
