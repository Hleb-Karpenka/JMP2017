package com.jmp.jpa;

import javax.persistence.*;

/**
 * Created by Gleb88 on 20.05.2017.
 */

@Entity
public class PersonalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "passport")
    private String passport;

    @OneToOne(mappedBy = "PersonalInfo")
    private Employee employee;

    public PersonalInfo() {
    }

    public PersonalInfo(long id, String passport, Employee employee) {
        this.id = id;
        this.passport = passport;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
