package com.epam.trainings.mentoring.jpa.domain.relationship.onetomany;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.*;

@Entity
public class Kid extends AbstractIdentified {
    @Column(name = "AGE")
    private int age;
    @ManyToOne
    @JoinColumn(name = "DADDY")
    private Daddy daddy;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Daddy getDaddy() {
        return daddy;
    }

    public void setDaddy(Daddy daddy) {
        this.daddy = daddy;
    }
}
