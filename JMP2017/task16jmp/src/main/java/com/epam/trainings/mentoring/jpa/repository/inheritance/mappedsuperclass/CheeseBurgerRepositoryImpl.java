package com.epam.trainings.mentoring.jpa.repository.inheritance.mappedsuperclass;

import com.epam.trainings.mentoring.jpa.domain.inheritance.mappedsuperclass.CheeseBurger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CheeseBurgerRepositoryImpl implements CheeseBurgerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CheeseBurger> findAll() {
        return this.entityManager.createQuery("SELECT c FROM CheeseBurger c", CheeseBurger.class)
                .getResultList();
    }
}
