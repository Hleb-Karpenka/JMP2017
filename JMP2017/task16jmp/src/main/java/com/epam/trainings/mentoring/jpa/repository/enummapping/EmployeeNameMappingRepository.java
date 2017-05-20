package com.epam.trainings.mentoring.jpa.repository.enummapping;


import com.epam.trainings.mentoring.jpa.domain.enummapping.EmployeeNameMapping;

import java.util.List;

public interface EmployeeNameMappingRepository {
    List<EmployeeNameMapping> findAll();
}
