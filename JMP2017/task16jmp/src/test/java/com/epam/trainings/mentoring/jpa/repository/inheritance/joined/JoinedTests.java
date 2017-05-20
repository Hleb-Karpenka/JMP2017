package com.epam.trainings.mentoring.jpa.repository.inheritance.joined;


import com.epam.trainings.mentoring.jpa.domain.inheritance.joined.HosomakiSushi;
import com.epam.trainings.mentoring.jpa.domain.inheritance.joined.NigiriSushi;
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
import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JoinedTests extends AbstractIntegrationTests {
    @Autowired
    private NigiriSushiRepository nigiriSushiRepository;
    @Autowired
    private HosomakiSushiRepository hosomakiSushiRepository;

    @Test
    public void findAllShouldReturnOnlyNigiriSushis() {
        //GIVEN
        prepareSushis();
        //WHEN
        List<NigiriSushi> sushis = nigiriSushiRepository.findAll();
        //THEN
        assertThat(sushis).hasSize(1);
        NigiriSushi roll = sushis.get(0);
        assertThat(roll.getRice()).isEqualTo(0.5);
        assertThat(roll.getSquid()).isEqualTo(0.3);
    }

    @Test
    public void findAllShouldReturnHosomakiSushis() {
        //GIVEN
        prepareSushis();
        //WHEN
        List<HosomakiSushi> sushis = hosomakiSushiRepository.findAll();
        //THEN
        assertThat(sushis).hasSize(1);
        HosomakiSushi roll = sushis.get(0);
        assertThat(roll.getRice()).isEqualTo(0.6);
        assertThat(roll.getNori()).isEqualTo(0.3);
    }

    private void prepareSushis() {
        Operation operation = sequenceOf(
                insertInto("SUSHI")
                        .columns("ID", "RICE", "SUSHI_TYPE")
                        .values(11, 0.5, "NIGIRI")
                        .values(13, 0.6, "HOSOMAKI")
                        .build(),
                insertInto("HOSOMAKI_SUSHI")
                        .columns("ID", "NORI")
                        .values(13, 0.3)
                        .build(),
                insertInto("NIGIRI_SUSHI")
                        .columns("ID", "SQUID")
                        .values(11, 0.3)
                        .build()
        );
        new DbSetup(destination, operation).launch();
    }
}
