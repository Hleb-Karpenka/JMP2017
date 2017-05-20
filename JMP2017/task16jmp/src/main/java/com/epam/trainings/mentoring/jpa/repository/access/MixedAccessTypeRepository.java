package com.epam.trainings.mentoring.jpa.repository.access;

import com.epam.trainings.mentoring.jpa.domain.access.MixedAccessType;

import java.util.List;

interface MixedAccessTypeRepository {
	List<MixedAccessType> findAll();
}
