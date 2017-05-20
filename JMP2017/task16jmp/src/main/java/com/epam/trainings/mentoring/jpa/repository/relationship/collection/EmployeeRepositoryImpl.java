package com.epam.trainings.mentoring.jpa.repository.relationship.collection;

import com.epam.trainings.mentoring.jpa.domain.relationship.collection.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee findBy(long id) {
        return entityManager.find(Employee.class, id);
    }
}
