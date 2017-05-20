package com.epam.trainings.mentoring.jpa.repository.relationship.onetoone;

import com.epam.trainings.mentoring.jpa.domain.relationship.onetoone.Husband;

public interface HusbandRepository {
    Husband findBy(long id);
}
