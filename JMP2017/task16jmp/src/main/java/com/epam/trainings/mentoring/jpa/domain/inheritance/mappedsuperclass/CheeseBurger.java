package com.epam.trainings.mentoring.jpa.domain.inheritance.mappedsuperclass;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CheeseBurger extends Burger {
    @Column(name = "BEEF")
    private double beef;
    @Column(name = "CHEESE")
    private double cheese;

    public double getBeef() {
        return beef;
    }

    public void setBeef(double beef) {
        this.beef = beef;
    }

    public double getCheese() {
        return cheese;
    }

    public void setCheese(double cheese) {
        this.cheese = cheese;
    }
}
