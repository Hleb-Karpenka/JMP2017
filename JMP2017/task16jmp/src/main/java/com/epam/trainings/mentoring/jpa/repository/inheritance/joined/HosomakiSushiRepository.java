package com.epam.trainings.mentoring.jpa.repository.inheritance.joined;

import com.epam.trainings.mentoring.jpa.domain.inheritance.joined.HosomakiSushi;

import java.util.List;

public interface HosomakiSushiRepository {
    List<HosomakiSushi> findAll();
}
