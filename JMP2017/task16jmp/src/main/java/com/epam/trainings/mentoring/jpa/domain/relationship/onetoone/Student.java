package com.epam.trainings.mentoring.jpa.domain.relationship.onetoone;


import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    private String name;
    @OneToOne(cascade = CascadeType.ALL)//address is aways bound to student
    @PrimaryKeyJoinColumn
    private StudentAddress address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentAddress getAddress() {
        return address;
    }

    public void setAddress(StudentAddress address) {
        this.address = address;
    }
}
