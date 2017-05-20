package com.epam.trainings.mentoring.jpa.domain.relationship.onetoone;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Wife extends AbstractIdentified {
    @OneToOne(mappedBy = "wife")
    private Husband husband;
    @Column(name = "NAME")
    private String name;

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
