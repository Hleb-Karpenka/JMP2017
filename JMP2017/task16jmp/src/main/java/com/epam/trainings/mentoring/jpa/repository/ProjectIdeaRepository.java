package com.epam.trainings.mentoring.jpa.repository;

import java.util.List;

import com.epam.trainings.mentoring.jpa.domain.ProjectIdea;

public interface ProjectIdeaRepository {

	List<ProjectIdea> findAll();

}
