package com.epam.trainings.mentoring.jpa.domain.inheritance.joined;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.*;

@Entity
@Table(name = "SUSHI")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "SUSHI_TYPE")
public class Sushi extends AbstractIdentified {
    @Column(name = "RICE")
    private double rice;

    public double getRice() {
        return rice;
    }

    public void setRice(double rice) {
        this.rice = rice;
    }
}
