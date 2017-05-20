package com.epam.trainings.mentoring.jpa.repository.inheritance.joined;

import com.epam.trainings.mentoring.jpa.domain.inheritance.joined.NigiriSushi;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class NigiriSushiRepositoryImpl implements NigiriSushiRepository  {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<NigiriSushi> findAll() {
        return this.entityManager.createQuery("SELECT s FROM NigiriSushi s", NigiriSushi.class)
                .getResultList();
    }
}
