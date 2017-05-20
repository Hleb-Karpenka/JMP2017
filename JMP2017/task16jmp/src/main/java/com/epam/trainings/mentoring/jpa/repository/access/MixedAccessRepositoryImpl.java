package com.epam.trainings.mentoring.jpa.repository.access;

import com.epam.trainings.mentoring.jpa.domain.access.MixedAccessType;
import com.epam.trainings.mentoring.jpa.domain.access.PropertyAccessType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MixedAccessRepositoryImpl implements MixedAccessTypeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<MixedAccessType> findAll() {
		return this.entityManager.createQuery("SELECT f FROM MixedAccessType f", MixedAccessType.class)
				.getResultList();
	}

}
