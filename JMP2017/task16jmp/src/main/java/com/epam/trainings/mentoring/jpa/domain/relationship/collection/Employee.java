package com.epam.trainings.mentoring.jpa.domain.relationship.collection;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee extends AbstractIdentified {
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "SECOND_NAME")
    private String secondName;
    @ElementCollection
    @CollectionTable(
            name = "EMAIL",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID")
    )
    @Column(name = "EMAIL")
    private List<String> emails = new ArrayList<>();

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

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}
