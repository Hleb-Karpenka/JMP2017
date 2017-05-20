package com.epam.trainings.mentoring.jpa.repository.inheritance.tableperclass;

import com.epam.trainings.mentoring.jpa.domain.inheritance.tableperclass.ClassicSandwich;

import java.util.List;

public interface ClassicSandwichRepository {
    List<ClassicSandwich> findAll();
}
