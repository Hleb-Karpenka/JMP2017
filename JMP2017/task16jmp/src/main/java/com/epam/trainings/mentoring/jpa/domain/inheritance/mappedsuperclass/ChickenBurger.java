package com.epam.trainings.mentoring.jpa.domain.inheritance.mappedsuperclass;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverride(name = "bun", column = @Column(name = "FRENCH_BUN"))
public class ChickenBurger extends Burger {
    @Column(name = "CHICKEN")
    private double chicken;

    public double getChicken() {
        return chicken;
    }

    public void setChicken(double chicken) {
        this.chicken = chicken;
    }
}
