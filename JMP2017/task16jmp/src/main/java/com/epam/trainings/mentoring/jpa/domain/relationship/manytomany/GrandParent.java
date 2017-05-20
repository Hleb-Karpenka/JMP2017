package com.epam.trainings.mentoring.jpa.domain.relationship.manytomany;


import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GrandParent extends AbstractIdentified {
    @Column(name = "NAME")
    private String name;
    @ManyToMany
    @JoinTable(
            name = "GRANDPA_TO_GRANDCHILD",
            joinColumns = @JoinColumn(name = "GRANDPA_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "GRANDCHILD_ID", referencedColumnName = "ID"))
    private Set<GrandChild> grandChildren = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GrandChild> getGrandChildren() {
        return grandChildren;
    }

    protected void setGrandChildren(Set<GrandChild> grandChildren) {
        this.grandChildren = grandChildren;
    }
}
