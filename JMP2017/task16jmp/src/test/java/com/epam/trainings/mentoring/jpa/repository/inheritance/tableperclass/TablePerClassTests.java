package com.epam.trainings.mentoring.jpa.repository.inheritance.tableperclass;


import com.epam.trainings.mentoring.jpa.domain.inheritance.tableperclass.ClassicSandwich;
import com.epam.trainings.mentoring.jpa.domain.inheritance.tableperclass.HawaiiSandwich;
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
import static com.ninja_squad.dbsetup.Operations.sequenceOf;
import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TablePerClassTests extends AbstractIntegrationTests {
    @Autowired
    private ClassicSandwichRepository classicSandwichRepository;
    @Autowired
    private HawaiiSandwichRepository hawaiiSandwichRepository;

    @Test
    public void findAllShouldReturnOnlyClassicSandwiches() {
        //GIVEN
        prepareSandwiches();
        //WHEN
        List<ClassicSandwich> classicSandwiches = classicSandwichRepository.findAll();
        //THEN
        assertThat(classicSandwiches).hasSize(2);
        ClassicSandwich classicSandwich = classicSandwiches.get(0);
        assertThat(classicSandwich.getBread()).isEqualTo(0.2);
        assertThat(classicSandwich.getCheese()).isEqualTo(0.5);
        assertThat(classicSandwich.getSausage()).isEqualTo(0.4);
    }

    @Test
    public void findAllShouldReturnOnlyHawaiiSandwiches() {
        //GIVEN
        prepareSandwiches();
        //WHEN
        List<HawaiiSandwich> hawaiiSandwiches = hawaiiSandwichRepository.findAll();
        //THEN
        assertThat(hawaiiSandwiches).hasSize(1);
        HawaiiSandwich hawaiiSandwich = hawaiiSandwiches.get(0);
        assertThat(hawaiiSandwich.getBread()).isEqualTo(0.2);
        assertThat(hawaiiSandwich.getPineapple()).isEqualTo(0.3);
    }

    private void prepareSandwiches() {
        Operation operation = sequenceOf(
                insertInto("CLASSIC_SANDWICH")
                        .withGeneratedValue("ID", ValueGenerators.sequence())
                        .columns("BREAD", "CHEESE", "SAUSAGE")
                        .values(0.2, 0.5, 0.4)
                        .values(0.2, 0.6, 0.4)
                        .build(),
                insertInto("HAWAII_SANDWICH")
                        .withGeneratedValue("ID", ValueGenerators.sequence())
                        .columns("BREAD", "PINE_APPLE")
                        .values(0.2, 0.3)
                        .build()
        );
        new DbSetup(destination, operation).launch();
    }
}
