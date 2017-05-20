package com.epam.trainings.mentoring.jpa.domain.inheritance.joined;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "NIGIRI_SUSHI")
@DiscriminatorValue("NIGIRI")
public class NigiriSushi extends Sushi {
    private double squid;

    public double getSquid() {
        return squid;
    }

    public void setSquid(double squid) {
        this.squid = squid;
    }
}
