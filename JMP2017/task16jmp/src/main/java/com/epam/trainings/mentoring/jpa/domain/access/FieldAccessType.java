package com.epam.trainings.mentoring.jpa.domain.access;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.*;

@Entity
@Table(name = "FIELD_ACCESS_TYPE")
@Access(AccessType.FIELD)//can be removed
public class FieldAccessType extends AbstractIdentified {
    @Column(name = "NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
