package com.epam.trainings.mentoring.jpa.domain.inheritance.tableperclass;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class HawaiiSandwich extends Sandwich {
    @Column(name = "PINE_APPLE")
    private double pineapple;

    public double getPineapple() {
        return pineapple;
    }

    public void setPineapple(double pineapple) {
        this.pineapple = pineapple;
    }
}
