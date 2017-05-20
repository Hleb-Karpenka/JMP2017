package com.epam.trainings.mentoring.jpa.domain.inheritance.tableperclass;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Sandwich {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)//we cannot use AUTO
    private long id;
    @Column(name = "BREAD")
    private double bread;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBread() {
        return bread;
    }

    public void setBread(double bread) {
        this.bread = bread;
    }
}
