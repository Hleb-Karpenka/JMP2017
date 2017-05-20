package com.epam.trainings.mentoring.jpa.repository.inheritance.mappedsuperclass;

import com.epam.trainings.mentoring.jpa.domain.inheritance.mappedsuperclass.ChickenBurger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ChickenBurgerRepositoryImpl implements ChickenBurgerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ChickenBurger> findAll() {
        return this.entityManager.createQuery("SELECT c FROM ChickenBurger c", ChickenBurger.class)
                .getResultList();
    }
}
