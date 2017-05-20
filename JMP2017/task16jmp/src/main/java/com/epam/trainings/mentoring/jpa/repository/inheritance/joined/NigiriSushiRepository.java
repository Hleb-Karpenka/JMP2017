package com.epam.trainings.mentoring.jpa.repository.inheritance.joined;

import com.epam.trainings.mentoring.jpa.domain.inheritance.joined.NigiriSushi;

import java.util.List;

public interface NigiriSushiRepository {
    List<NigiriSushi> findAll();
}
