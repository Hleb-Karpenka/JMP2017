package com.epam.trainings.mentoring.jpa.repository.relationship.manytomany;

import com.epam.trainings.mentoring.jpa.domain.relationship.manytomany.GrandParent;

import java.util.List;

public interface GrandParentRepository {
    List<GrandParent> findAll();
}
