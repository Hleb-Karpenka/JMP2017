package com.epam.trainings.mentoring.jpa.domain.relationship.onetomany;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Daddy extends AbstractIdentified {
    @Column(name = "NAME")
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "daddy", cascade = CascadeType.ALL)
    private List<Kid> kids = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Kid> getKids() {
        return kids;
    }

    protected void setKids(List<Kid> kids) {
        this.kids = kids;
    }
}
