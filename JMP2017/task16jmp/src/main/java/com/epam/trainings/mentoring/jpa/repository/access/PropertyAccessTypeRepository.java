package com.epam.trainings.mentoring.jpa.repository.access;

import com.epam.trainings.mentoring.jpa.domain.access.PropertyAccessType;

import java.util.List;

interface PropertyAccessTypeRepository {
	List<PropertyAccessType> findAll();
}
