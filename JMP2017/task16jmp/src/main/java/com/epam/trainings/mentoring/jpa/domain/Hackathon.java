package com.epam.trainings.mentoring.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "HACKATHON")
public class Hackathon extends AbstractIdentified {
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private String description;
	@ManyToMany
	private List<ProjectIdea> projectIdeas;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProjectIdea> getProjectIdeas() {
		return this.projectIdeas;
	}

	public void setProjectIdeas(List<ProjectIdea> projectIdeas) {
		this.projectIdeas = projectIdeas;
	}

}
