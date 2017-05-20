package com.epam.trainings.mentoring.jpa.repository.relationship.onetoone;

import com.epam.trainings.mentoring.jpa.domain.relationship.onetoone.Student;

public interface StudentRepository {

    void save(Student student);
}
