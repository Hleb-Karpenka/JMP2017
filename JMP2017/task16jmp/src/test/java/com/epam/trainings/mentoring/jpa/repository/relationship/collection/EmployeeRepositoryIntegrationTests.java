package com.epam.trainings.mentoring.jpa.repository.relationship.collection;

import com.epam.trainings.mentoring.jpa.domain.relationship.collection.Employee;
import com.epam.trainings.mentoring.jpa.repository.AbstractIntegrationTests;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.operation.Operation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EmployeeRepositoryIntegrationTests extends AbstractIntegrationTests {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void findShouldReturnEmployeeWithEmailAddresses() {
        //GIVEN
        Operation operation = sequenceOf(
                insertInto("EMPLOYEE")
                        .columns("ID", "FIRST_NAME", "SECOND_NAME")
                        .values(1, "Anuar", "Nurmakanov")
                        .values(2, "Almas", "Doskozhin")
                        .build(),
                insertInto("EMAIL")
                        .columns("EMPLOYEE_ID", "EMAIL")
                        .values(1, "Anuar_Nurmakanov@epam.com")
                        .values(1, "sshogunn@gmail.com")
                        .build()
        );
        new DbSetup(destination, operation).launch();
        //WHEN
        Employee anuar = employeeRepository.findBy(1);
        //THEN
        List<String> emails = anuar.getEmails();
        assertThat(emails).contains("Anuar_Nurmakanov@epam.com", "sshogunn@gmail.com");
    }
}
