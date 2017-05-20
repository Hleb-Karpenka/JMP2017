package com.epam.trainings.mentoring.jpa.repository.embedded;

import com.epam.trainings.mentoring.jpa.domain.embedded.Address;
import com.epam.trainings.mentoring.jpa.domain.embedded.Company;
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
public class CompanyRepositoryIntegrationTests extends AbstractIntegrationTests {
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void findsAllShouldReturnAllCompaniesWithAddresses() {
        //GIVEN
        Operation operation = insertInto("COMPANY")
                .withGeneratedValue("ID", ValueGenerators.sequence())
                .columns("NAME", "STREET", "HOUSE", "FLAT")
                .values("EPAM Systems", "Ermekova", 58, 3)
                .build();
        new DbSetup(destination, operation).launch();
        //WHEN
        List<Company> values = this.companyRepository.findAll();
        //THEN
        assertThat(values).hasSize(1);
        Company company = values.get(0);
        Address address = company.getAddress();
        assertThat(address.getStreet()).isEqualTo("Ermekova");
        assertThat(address.getHouse()).isEqualTo(58);
        assertThat(address.getFlat()).isEqualTo(3);
    }
}
