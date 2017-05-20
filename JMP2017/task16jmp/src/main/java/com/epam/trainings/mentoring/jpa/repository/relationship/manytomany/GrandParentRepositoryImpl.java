package com.epam.trainings.mentoring.jpa.repository.relationship.manytomany;

import com.epam.trainings.mentoring.jpa.domain.relationship.manytomany.GrandParent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GrandParentRepositoryImpl implements GrandParentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<GrandParent> findAll() {
        return this.entityManager.createQuery("SELECT gp FROM GrandParent gp", GrandParent.class)
                .getResultList();
    }
}
