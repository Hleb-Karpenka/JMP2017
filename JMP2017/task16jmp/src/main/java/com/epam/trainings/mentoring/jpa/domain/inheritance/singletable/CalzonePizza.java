package com.epam.trainings.mentoring.jpa.domain.inheritance.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CALZONE")
public class CalzonePizza extends Pizza {
    @Column(name = "EGGS")
    private double eggs;

    public double getEggs() {
        return eggs;
    }

    public void setEggs(double eggs) {
        this.eggs = eggs;
    }
}
