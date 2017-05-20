package com.epam.trainings.mentoring.jpa.repository.relationship.manytomany;

import com.epam.trainings.mentoring.jpa.domain.relationship.manytomany.GrandChild;

import java.util.List;

public interface GrandChildRepository {
    List<GrandChild> findAll();
}
