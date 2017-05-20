package com.epam.trainings.mentoring.jpa.repository.enummapping;

import com.epam.trainings.mentoring.jpa.domain.enummapping.EmployeeOrdinalMapping;

import java.util.List;

public interface EmployeeOrdinalMappingRepository {
    List<EmployeeOrdinalMapping> findAll();
}
