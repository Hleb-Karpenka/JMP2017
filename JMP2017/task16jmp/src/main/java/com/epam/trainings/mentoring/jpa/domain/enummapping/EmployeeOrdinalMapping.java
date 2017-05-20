package com.epam.trainings.mentoring.jpa.domain.enummapping;

import com.epam.trainings.mentoring.jpa.domain.AbstractIdentified;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE_ORDINAL_MAPPING")
public class EmployeeOrdinalMapping extends AbstractIdentified {
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ENGLISH_LEVEL")
    private EnglishLevel englishLevel;

    public EnglishLevel getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(EnglishLevel englishLevel) {
        this.englishLevel = englishLevel;
    }
}
