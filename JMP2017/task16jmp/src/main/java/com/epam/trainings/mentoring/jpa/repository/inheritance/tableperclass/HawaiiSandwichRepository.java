package com.epam.trainings.mentoring.jpa.repository.inheritance.tableperclass;

import com.epam.trainings.mentoring.jpa.domain.inheritance.tableperclass.HawaiiSandwich;

import java.util.List;

public interface HawaiiSandwichRepository {
    List<HawaiiSandwich> findAll();
}
