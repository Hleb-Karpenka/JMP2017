package com.epam.trainings.mentoring.jpa.repository.inheritance.mappedsuperclass;

import com.epam.trainings.mentoring.jpa.domain.inheritance.mappedsuperclass.CheeseBurger;

import java.util.List;

public interface CheeseBurgerRepository {
    List<CheeseBurger> findAll();
}
