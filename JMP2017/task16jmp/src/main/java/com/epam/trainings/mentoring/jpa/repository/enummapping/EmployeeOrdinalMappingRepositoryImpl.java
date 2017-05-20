package com.epam.trainings.mentoring.jpa.repository.enummapping;


import com.epam.trainings.mentoring.jpa.domain.enummapping.EmployeeOrdinalMapping;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeOrdinalMappingRepositoryImpl implements EmployeeOrdinalMappingRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EmployeeOrdinalMapping> findAll() {
        return this.entityManager.createQuery("SELECT h FROM EmployeeOrdinalMapping h", EmployeeOrdinalMapping.class)
                .getResultList();
    }
}
