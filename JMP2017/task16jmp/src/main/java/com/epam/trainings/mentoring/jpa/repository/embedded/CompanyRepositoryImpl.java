package com.epam.trainings.mentoring.jpa.repository.embedded;

import com.epam.trainings.mentoring.jpa.domain.embedded.Company;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> findAll() {
        return this.entityManager.createQuery("SELECT c FROM Company c", Company.class)
                .getResultList();
    }
}
