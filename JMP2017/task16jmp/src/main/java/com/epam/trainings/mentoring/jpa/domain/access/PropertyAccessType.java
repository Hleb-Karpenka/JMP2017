package com.epam.trainings.mentoring.jpa.domain.access;

import javax.persistence.*;

@Entity
@Table(name = "PROPERTY_ACCESS_TYPE")
@Access(AccessType.PROPERTY)//can be removed
public class PropertyAccessType {
    private long id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
