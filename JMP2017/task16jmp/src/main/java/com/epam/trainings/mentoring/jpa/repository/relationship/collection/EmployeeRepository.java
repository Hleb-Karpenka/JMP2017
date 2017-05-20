package com.epam.trainings.mentoring.jpa.repository.relationship.collection;

import com.epam.trainings.mentoring.jpa.domain.relationship.collection.Employee;

public interface EmployeeRepository {
    Employee findBy(long id);
}
