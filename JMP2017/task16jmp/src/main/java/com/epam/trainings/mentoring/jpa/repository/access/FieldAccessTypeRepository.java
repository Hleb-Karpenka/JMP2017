package com.epam.trainings.mentoring.jpa.repository.access;

import com.epam.trainings.mentoring.jpa.domain.access.FieldAccessType;

import java.util.List;

interface FieldAccessTypeRepository {
	List<FieldAccessType> findAll();
}
