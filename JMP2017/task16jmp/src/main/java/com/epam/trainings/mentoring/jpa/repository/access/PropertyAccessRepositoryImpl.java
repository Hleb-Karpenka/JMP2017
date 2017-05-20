package com.epam.trainings.mentoring.jpa.repository.access;

import com.epam.trainings.mentoring.jpa.domain.access.PropertyAccessType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PropertyAccessRepositoryImpl implements PropertyAccessTypeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<PropertyAccessType> findAll() {
		return this.entityManager.createQuery("SELECT f FROM PropertyAccessType f", PropertyAccessType.class)
				.getResultList();
	}

}
