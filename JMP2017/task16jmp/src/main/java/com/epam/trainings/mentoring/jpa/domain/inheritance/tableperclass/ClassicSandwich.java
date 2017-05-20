package com.epam.trainings.mentoring.jpa.domain.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ClassicSandwich extends Sandwich {
    @Column(name = "CHEESE")
    private double cheese;
    @Column(name = "SAUSAGE")
    private double sausage;

    public double getCheese() {
        return cheese;
    }

    public void setCheese(double cheese) {
        this.cheese = cheese;
    }

    public double getSausage() {
        return sausage;
    }

    public void setSausage(double sausage) {
        this.sausage = sausage;
    }
}
