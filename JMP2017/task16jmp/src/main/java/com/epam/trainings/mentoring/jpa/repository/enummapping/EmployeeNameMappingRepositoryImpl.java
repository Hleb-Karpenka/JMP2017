package com.epam.trainings.mentoring.jpa.repository.enummapping;


import com.epam.trainings.mentoring.jpa.domain.enummapping.EmployeeNameMapping;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeNameMappingRepositoryImpl implements EmployeeNameMappingRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EmployeeNameMapping> findAll() {
        return this.entityManager.createQuery("SELECT h FROM EmployeeNameMapping h", EmployeeNameMapping.class)
                .getResultList();
    }
}
