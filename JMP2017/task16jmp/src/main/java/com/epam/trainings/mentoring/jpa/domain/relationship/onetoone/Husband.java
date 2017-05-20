package com.epam.trainings.mentoring.jpa.domain.relationship.onetoone;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Husband extends AbstractIdentified {
    @Column(name = "NAME")
    private String name;
    @OneToOne
    @JoinColumn(name="wife")
    private Wife wife;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
