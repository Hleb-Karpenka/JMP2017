package com.epam.trainings.mentoring.jpa.repository.inheritance.singletable;

import com.epam.trainings.mentoring.jpa.domain.inheritance.singletable.RollzPizza;

import java.util.List;

public interface RollzPizzaRepository {
    List<RollzPizza> findAll();
}
