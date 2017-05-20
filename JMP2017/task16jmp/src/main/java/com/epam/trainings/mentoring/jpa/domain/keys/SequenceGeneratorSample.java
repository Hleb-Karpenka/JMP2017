package com.epam.trainings.mentoring.jpa.domain.keys;


import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class SequenceGeneratorSample {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
