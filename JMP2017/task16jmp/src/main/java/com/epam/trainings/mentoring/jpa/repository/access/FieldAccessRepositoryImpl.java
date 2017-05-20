package com.epam.trainings.mentoring.jpa.repository.access;

import com.epam.trainings.mentoring.jpa.domain.access.FieldAccessType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FieldAccessRepositoryImpl implements FieldAccessTypeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<FieldAccessType> findAll() {
		return this.entityManager.createQuery("SELECT f FROM FieldAccessType f", FieldAccessType.class)
				.getResultList();
	}

}
