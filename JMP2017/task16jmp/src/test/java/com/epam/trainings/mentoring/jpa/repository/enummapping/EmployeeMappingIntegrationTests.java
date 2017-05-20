package com.epam.trainings.mentoring.jpa.repository.enummapping;


import com.epam.trainings.mentoring.jpa.domain.enummapping.EmployeeNameMapping;
import com.epam.trainings.mentoring.jpa.domain.enummapping.EmployeeOrdinalMapping;
import com.epam.trainings.mentoring.jpa.domain.enummapping.EnglishLevel;
import com.epam.trainings.mentoring.jpa.repository.AbstractIntegrationTests;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.generator.ValueGenerators;
import com.ninja_squad.dbsetup.operation.Operation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.ninja_squad.dbsetup.Operations.insertInto;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EmployeeMappingIntegrationTests extends AbstractIntegrationTests {
    @Autowired
    private EmployeeOrdinalMappingRepository ordinalMappingRepository;
    @Autowired
    private EmployeeNameMappingRepository nameMappingRepository;

    @Test
    public void findsAllShouldReturnAllRecordsWhenEnumIsMappedByOrdinal() {
        //GIVEN
        Operation operation = insertInto("EMPLOYEE_ORDINAL_MAPPING")
                .withGeneratedValue("ID", ValueGenerators.sequence())
                .columns("ENGLISH_LEVEL")
                .values(2)
                .build();
        new DbSetup(destination, operation).launch();
        //WHEN
        List<EmployeeOrdinalMapping> values = this.ordinalMappingRepository.findAll();
        //THEN
        assertThat(values).hasSize(1);
        assertThat(values.get(0).getEnglishLevel()).isEqualTo(EnglishLevel.A2);
    }

    @Test
    public void findsAllShouldReturnAllRecordsWhenEnumIsMappedByName() {
        //GIVEN
        Operation operation = insertInto("EMPLOYEE_NAME_MAPPING")
                .withGeneratedValue("ID", ValueGenerators.sequence())
                .columns("ENGLISH_LEVEL")
                .values("A2")
                .build();
        new DbSetup(destination, operation).launch();
        //WHEN
        List<EmployeeNameMapping> values = this.nameMappingRepository.findAll();
        //THEN
        assertThat(values).hasSize(1);
        assertThat(values.get(0).getEnglishLevel()).isEqualTo(EnglishLevel.A2);
    }
}
