package com.epam.trainings.mentoring.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "PROJECT_IDEA")
public class ProjectIdea extends AbstractIdentified {

	@Column(name = "NAME")
	private String name;

	@ManyToMany(mappedBy = "projectIdeas")
	private List<Hackathon> hackathons;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Hackathon> getHackathons() {
		return this.hackathons;
	}

	public void setHackathons(List<Hackathon> hackathons) {
		this.hackathons = hackathons;
	}

}
