package com.epam.trainings.mentoring.jpa.repository;

import java.util.List;

import com.epam.trainings.mentoring.jpa.domain.Hackathon;

public interface HackathonRepository {

	List<Hackathon> findAll();
}
