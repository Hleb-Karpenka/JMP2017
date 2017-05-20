package com.epam.trainings.mentoring.jpa.domain.enummapping;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE_NAME_MAPPING")
public class EmployeeNameMapping extends AbstractIdentified {

    @Enumerated(EnumType.STRING)
    @Column(name = "ENGLISH_LEVEL")
    private EnglishLevel englishLevel;

    public EnglishLevel getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(EnglishLevel englishLevel) {
        this.englishLevel = englishLevel;
    }
}
