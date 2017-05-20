package com.epam.trainings.mentoring.jpa.domain.keys;


import javax.persistence.*;

@Entity
public class IdentityGeneratorSample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
