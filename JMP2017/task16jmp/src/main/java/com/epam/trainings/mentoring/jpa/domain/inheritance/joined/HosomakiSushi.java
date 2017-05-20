package com.epam.trainings.mentoring.jpa.domain.inheritance.joined;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HOSOMAKI_SUSHI")
@DiscriminatorValue("HOSOMAKI")
public class HosomakiSushi extends Sushi {
    @Column(name = "NORI")
    private double nori;

    public double getNori() {
        return nori;
    }

    public void setNori(double nori) {
        this.nori = nori;
    }
}
