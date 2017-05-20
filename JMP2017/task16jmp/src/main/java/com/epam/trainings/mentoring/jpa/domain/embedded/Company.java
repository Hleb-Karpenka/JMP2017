package com.epam.trainings.mentoring.jpa.domain.embedded;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company extends AbstractIdentified {
    @Column(name = "NAME")
    private String name;
    @Embedded
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
