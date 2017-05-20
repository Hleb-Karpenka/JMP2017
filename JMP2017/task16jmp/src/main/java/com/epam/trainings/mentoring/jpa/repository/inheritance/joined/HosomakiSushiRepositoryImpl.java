package com.epam.trainings.mentoring.jpa.repository.inheritance.joined;

import com.epam.trainings.mentoring.jpa.domain.inheritance.joined.HosomakiSushi;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HosomakiSushiRepositoryImpl implements HosomakiSushiRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HosomakiSushi> findAll() {
        return this.entityManager.createQuery("SELECT s FROM HosomakiSushi s", HosomakiSushi.class)
                .getResultList();
    }
}
