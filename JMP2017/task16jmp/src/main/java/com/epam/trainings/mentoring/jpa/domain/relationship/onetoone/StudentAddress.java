package com.epam.trainings.mentoring.jpa.domain.relationship.onetoone;


import javax.persistence.*;

@Entity
public class StudentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSE")
    private int house;
    @OneToOne(mappedBy = "address")
    private Student student;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
