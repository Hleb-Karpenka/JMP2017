package com.epam.trainings.mentoring.jpa.domain.inheritance.mappedsuperclass;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Burger extends AbstractIdentified {
    @Column(name = "BUN")
    private double bun;

    public double getBun() {
        return bun;
    }

    public void setBun(double bun) {
        this.bun = bun;
    }
}
