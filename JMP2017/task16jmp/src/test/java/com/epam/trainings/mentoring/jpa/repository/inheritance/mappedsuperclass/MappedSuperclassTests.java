package com.epam.trainings.mentoring.jpa.repository.inheritance.mappedsuperclass;


import com.epam.trainings.mentoring.jpa.domain.inheritance.mappedsuperclass.CheeseBurger;
import com.epam.trainings.mentoring.jpa.domain.inheritance.mappedsuperclass.ChickenBurger;
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
public class MappedSuperclassTests extends AbstractIntegrationTests {
    @Autowired
    private CheeseBurgerRepository cheeseBurgerRepository;
    @Autowired
    private ChickenBurgerRepository chickenBurgerRepository;

    @Test
    public void findAllShouldReturnAllCheeseBurgers() {
        //GIVEN
        prepareBurgers();
        //WHEN
        List<CheeseBurger> cheeseBurgers = cheeseBurgerRepository.findAll();
        //THEN
        assertThat(cheeseBurgers).hasSize(2);
        CheeseBurger firstBurger = cheeseBurgers.get(0);

        assertThat(firstBurger.getBun()).isEqualTo(0.5);
        assertThat(firstBurger.getBeef()).isEqualTo(0.8);
        assertThat(firstBurger.getCheese()).isEqualTo(0.6);
    }

    @Test
    public void findAllShouldReturnAllChickenBurgers() {
        //GIVEN
        prepareBurgers();
        //WHEN
        List<ChickenBurger> chickenBurgers = chickenBurgerRepository.findAll();
        //THEN
        assertThat(chickenBurgers).hasSize(2);
        ChickenBurger firstBurger = chickenBurgers.get(0);

        assertThat(firstBurger.getBun()).isEqualTo(0.7);
        assertThat(firstBurger.getChicken()).isEqualTo(0.3);
    }

    private void prepareBurgers() {
        Operation operation = sequenceOf(
                insertInto("CHEESE_BURGER")
                        .withGeneratedValue("ID", ValueGenerators.sequence())
                        .columns("BUN", "BEEF", "CHEESE")
                        .values(0.5, 0.8, 0.6)
                        .values(0.4, 0.3, 0.7)
                        .build(),
                insertInto("CHICKEN_BURGER")
                        .withGeneratedValue("ID", ValueGenerators.sequence())
                        .columns("FRENCH_BUN", "CHICKEN")
                        .values(0.7, 0.3)
                        .values(0.4, 0.2)
                        .build()
        );
        new DbSetup(destination, operation).launch();
    }
}
