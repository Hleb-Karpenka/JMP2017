package com.epam.trainings.mentoring.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.epam.trainings.mentoring.jpa.domain.Hackathon;

import org.springframework.stereotype.Repository;

@Repository
public class HackathonRepositoryImpl implements HackathonRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hackathon> findAll() {
		return this.entityManager.createQuery("SELECT h FROM Hackathon h", Hackathon.class)
				.getResultList();
	}

}
