package com.epam.trainings.mentoring.jpa.domain.relationship.manytomany;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GrandChild extends AbstractIdentified {
    @Column(name = "NAME")
    private String name;
    @ManyToMany(mappedBy = "grandChildren")
    private Set<GrandParent> grandParents = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GrandParent> getGrandParents() {
        return grandParents;
    }

    protected void setGrandParents(Set<GrandParent> grandParents) {
        this.grandParents = grandParents;
    }
}
