package com.epam.trainings.mentoring.jpa.repository.defaultbehavior;


import com.epam.trainings.mentoring.jpa.domain.defaultbehavior.ChangeMyMapping;
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
public class ChangeMyMappingIntegrationTests extends AbstractIntegrationTests {
    @Autowired
    private ChangeMyMappingRepositoryImpl changeMyMappingRepository;

    @Test
    public void findsAllShouldReturnAllRecords() {
        //GIVEN
        Operation operation = insertInto("CHANGE_ME")
                .withGeneratedValue("ID", ValueGenerators.sequence())
                .columns("CHANGE_NAME")
                .values("Ok! I will change mapping!")
                .build();
        new DbSetup(destination, operation).launch();
        //WHEN
        List<ChangeMyMapping> values = this.changeMyMappingRepository.findAll();
        //THEN
        assertThat(values).hasSize(1);
    }
}
