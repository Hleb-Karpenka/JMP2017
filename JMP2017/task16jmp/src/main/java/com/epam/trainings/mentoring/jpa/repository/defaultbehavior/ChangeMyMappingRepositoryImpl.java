package com.epam.trainings.mentoring.jpa.repository.defaultbehavior;


import com.epam.trainings.mentoring.jpa.domain.defaultbehavior.ChangeMyMapping;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ChangeMyMappingRepositoryImpl implements ChangeMyMappingRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ChangeMyMapping> findAll() {
        return this.entityManager.createQuery("SELECT cmp FROM ChangeMyMapping cmp", ChangeMyMapping.class)
                .getResultList();
    }
}
