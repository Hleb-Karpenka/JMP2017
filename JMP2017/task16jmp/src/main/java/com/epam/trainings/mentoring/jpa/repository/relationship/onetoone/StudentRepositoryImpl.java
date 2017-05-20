package com.epam.trainings.mentoring.jpa.repository.relationship.onetoone;

import com.epam.trainings.mentoring.jpa.domain.relationship.onetoone.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Student student) {
        this.entityManager.persist(student);
    }
}
