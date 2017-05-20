package com.epam.trainings.mentoring.jpa.domain.defaultbehavior;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.*;

@Entity
@Table(name = "CHANGE_ME")
public class ChangeMyMapping extends AbstractIdentified {
    @Column(name = "CHANGE_NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
