package com.epam.trainings.mentoring.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.epam.trainings.mentoring.jpa.domain.ProjectIdea;

import org.springframework.stereotype.Repository;

@Repository
public class ProjectIdeaRepositoryImpl implements ProjectIdeaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ProjectIdea> findAll() {
		return this.entityManager.createQuery("SELECT pi FROM ProjectIdea pi", ProjectIdea.class)
				.getResultList();
	}

}
