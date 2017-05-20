package com.epam.trainings.mentoring.jpa.repository.relationship.onetomany;

import com.epam.trainings.mentoring.jpa.domain.relationship.onetomany.Kid;

import java.util.List;

public interface KidRepository {
    List<Kid> findAll();
}
