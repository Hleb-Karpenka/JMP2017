package com.epam.trainings.mentoring.jpa.repository.inheritance.mappedsuperclass;


import com.epam.trainings.mentoring.jpa.domain.inheritance.mappedsuperclass.ChickenBurger;

import java.util.List;

public interface ChickenBurgerRepository {
    List<ChickenBurger> findAll();
}
