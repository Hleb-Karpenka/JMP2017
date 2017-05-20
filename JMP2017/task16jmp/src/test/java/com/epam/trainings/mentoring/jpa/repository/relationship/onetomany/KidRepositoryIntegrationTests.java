package com.epam.trainings.mentoring.jpa.repository.relationship.onetomany;

import com.epam.trainings.mentoring.jpa.domain.relationship.onetomany.Kid;
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
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class KidRepositoryIntegrationTests extends AbstractIntegrationTests {
    @Autowired
    private KidRepository kidRepository;

    @Test
    public void shouldReturnKidsWithDaddy() {
        //GIVEN
        Operation operation = sequenceOf(
                insertInto("DADDY")
                        .columns("ID", "NAME")
                        .values(100, "The best of the best!")
                        .build(),
                insertInto("KID")
                        .withGeneratedValue("ID", ValueGenerators.sequence())
                        .columns("NAME", "DADDY")
                        .values("We did not expect you, baby!", 100)
                        .values("You are expected =)", 100)
                        .values("Surprise!", 100)
                        .build()
        );
        new DbSetup(destination, operation).launch();
        //WHEN
        List<Kid> kids = kidRepository.findAll();
        //THEN
        assertThat(kids).hasSize(3);
        assertThat(kids.get(0).getDaddy().getId()).isEqualTo(100);
    }
}
