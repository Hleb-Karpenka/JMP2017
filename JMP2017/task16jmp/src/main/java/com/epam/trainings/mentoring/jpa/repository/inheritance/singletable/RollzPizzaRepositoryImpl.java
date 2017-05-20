package com.epam.trainings.mentoring.jpa.repository.inheritance.singletable;

import com.epam.trainings.mentoring.jpa.domain.inheritance.singletable.RollzPizza;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RollzPizzaRepositoryImpl implements RollzPizzaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RollzPizza> findAll() {
        return this.entityManager.createQuery("SELECT p FROM RollzPizza p", RollzPizza.class)
                .getResultList();
    }
}
