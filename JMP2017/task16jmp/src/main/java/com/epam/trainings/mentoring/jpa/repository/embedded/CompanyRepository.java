package com.epam.trainings.mentoring.jpa.repository.embedded;

import com.epam.trainings.mentoring.jpa.domain.embedded.Company;

import java.util.List;

public interface CompanyRepository {
    List<Company> findAll();
}
