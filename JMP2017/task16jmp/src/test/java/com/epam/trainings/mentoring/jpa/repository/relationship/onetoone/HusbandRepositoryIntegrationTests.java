package com.epam.trainings.mentoring.jpa.repository.relationship.onetoone;


import com.epam.trainings.mentoring.jpa.domain.relationship.onetoone.Husband;
import com.epam.trainings.mentoring.jpa.repository.AbstractIntegrationTests;
import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.operation.Operation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class HusbandRepositoryIntegrationTests extends AbstractIntegrationTests {
    @Autowired
    private HusbandRepository husbandRepository;

    @Test
    public void shouldReturnHusbandWithWife() {
        //GIVEN
        Operation operation = sequenceOf(
                insertInto("WIFE")
                        .columns("ID", "NAME")
                        .values(10, "A wife who does not have any questions")
                        .build(),
                insertInto("HUSBAND")
                        .columns("ID", "NAME", "WIFE")
                        .values(100, "The best husband in the world!", 10)
                        .build()
        );
        new DbSetup(destination, operation).launch();
        long husbandId = 100;
        //WHEN
        Husband husband = husbandRepository.findBy(husbandId);
        //THEN
        assertThat(husband.getWife().getName()).isEqualTo("A wife who does not have any questions");
    }
}
