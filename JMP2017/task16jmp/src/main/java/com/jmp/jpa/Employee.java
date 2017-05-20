package com.jmp.jpa;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gleb88 on 20.05.2017.
 */

@Entity
public class Employee {
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "SECOND_NAME")
    private String secondName;
    @ElementCollection
    @CollectionTable(
            name = "EmployeeStatus",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID")
    )
    @Column(name = "EmployeeStatus")
    private EmployeeStatus employeeStatus;
    @Embedded
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)//address is aways bound to student
    @PrimaryKeyJoinColumn
    private PersonalInfo personalInfo;

    @ManyToMany
    @JoinTable(
            name = "EMPLOYEE_TO_PROJECT",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID"))
    private Set<Project> projects = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "UNIT")
    private Unit unit;

    public Employee(String firstName, String secondName, EmployeeStatus employeeStatus, Address address, PersonalInfo personalInfo, Set<Project> projects, Unit unit) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.employeeStatus = employeeStatus;
        this.address = address;
        this.personalInfo = personalInfo;
        this.projects = projects;
        this.unit = unit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
