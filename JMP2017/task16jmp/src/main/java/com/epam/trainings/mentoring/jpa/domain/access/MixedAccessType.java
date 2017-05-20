package com.epam.trainings.mentoring.jpa.domain.access;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.*;

@Entity
@Table(name = "MIXED_ACCESS_TYPE")
@Access(AccessType.FIELD)
public class MixedAccessType extends AbstractIdentified {
    @Column(name = "NEW_NAME")
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DESCRIPTION")
    @Access(AccessType.PROPERTY)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
