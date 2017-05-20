package com.epam.trainings.mentoring.jpa.repository.inheritance.singletable;

import com.epam.trainings.mentoring.jpa.domain.inheritance.singletable.CalzonePizza;

import java.util.List;

public interface CalzonePizzaRepository {
    List<CalzonePizza> findAll();
}
