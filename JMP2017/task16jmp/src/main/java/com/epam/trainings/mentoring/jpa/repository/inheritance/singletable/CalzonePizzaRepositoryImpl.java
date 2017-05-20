package com.epam.trainings.mentoring.jpa.repository.inheritance.singletable;

import com.epam.trainings.mentoring.jpa.domain.inheritance.singletable.CalzonePizza;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CalzonePizzaRepositoryImpl implements CalzonePizzaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CalzonePizza> findAll() {
        return this.entityManager.createQuery("SELECT p FROM CalzonePizza p", CalzonePizza.class)
                .getResultList();
    }
}
