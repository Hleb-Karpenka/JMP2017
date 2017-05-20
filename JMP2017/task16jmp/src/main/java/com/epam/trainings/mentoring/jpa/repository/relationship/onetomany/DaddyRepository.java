package com.epam.trainings.mentoring.jpa.repository.relationship.onetomany;

import com.epam.trainings.mentoring.jpa.domain.relationship.onetomany.Daddy;

public interface DaddyRepository {
    Daddy findBy(long id);
}
