package com.epam.trainings.mentoring.jpa.repository.defaultbehavior;


import com.epam.trainings.mentoring.jpa.domain.defaultbehavior.ChangeMyMapping;

import java.util.List;

public interface ChangeMyMappingRepository {
    List<ChangeMyMapping> findAll();
}
