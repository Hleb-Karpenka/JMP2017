package com.epam.trainings.mentoring.jpa.repository.inheritance.singletable;


import com.epam.trainings.mentoring.jpa.domain.inheritance.singletable.CalzonePizza;
import com.epam.trainings.mentoring.jpa.domain.inheritance.singletable.PizzaSize;
import com.epam.trainings.mentoring.jpa.domain.inheritance.singletable.RollzPizza;
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
public class SingleTableInheritanceTests extends AbstractIntegrationTests {
    @Autowired
    private CalzonePizzaRepository calzonePizzaRepository;
    @Autowired
    private RollzPizzaRepository rollzPizzaRepository;

    @Test
    public void shouldReturnOnlyCalzonePizzas() {
        //GIVEN
        preparePizzas();
        //WHEN
        List<CalzonePizza> pizzaList = calzonePizzaRepository.findAll();
        //THEN
        assertThat(pizzaList).hasSize(1);
        CalzonePizza calzonePizza = pizzaList.get(0);
        assertThat(calzonePizza.getEggs()).isEqualTo(0.4);
    }

    @Test
    public void shouldReturnOnlyRollzPizzas() {
        //GIVEN
        preparePizzas();
        //WHEN
        List<RollzPizza> pizzaList = rollzPizzaRepository.findAll();
        //THEN
        assertThat(pizzaList).hasSize(1);
        RollzPizza rollzPizza = pizzaList.get(0);
        assertThat(rollzPizza.getSausages()).isEqualTo(0.3);
    }

    private void preparePizzas() {
        Operation operation = insertInto("PIZZA")
                .withGeneratedValue("ID", ValueGenerators.sequence())
                .columns("PIZZA_TYPE", "DOUGH", "SIZE", "EGGS", "SAUSAGES")
                .values("CALZONE", 0.5, PizzaSize.MEDIUM, 0.4, null)
                .values("ROLLZ", 0.5, PizzaSize.SMALL, null, 0.3)
                .build();
        new DbSetup(destination, operation).launch();
    }
}
