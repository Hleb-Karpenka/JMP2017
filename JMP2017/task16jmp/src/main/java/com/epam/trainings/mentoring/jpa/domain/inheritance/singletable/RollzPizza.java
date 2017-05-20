package com.epam.trainings.mentoring.jpa.domain.inheritance.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ROLLZ")
public class RollzPizza extends Pizza {
    @Column(name = "SAUSAGES")
    private double sausages;

    public double getSausages() {
        return sausages;
    }

    public void setSausages(double sausages) {
        this.sausages = sausages;
    }
}
