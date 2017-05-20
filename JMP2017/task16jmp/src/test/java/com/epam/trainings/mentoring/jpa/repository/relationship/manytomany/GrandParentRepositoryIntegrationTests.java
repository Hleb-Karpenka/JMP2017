package com.epam.trainings.mentoring.jpa.repository.relationship.manytomany;

import com.epam.trainings.mentoring.jpa.domain.relationship.manytomany.GrandParent;
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
public class GrandParentRepositoryIntegrationTests extends AbstractIntegrationTests {
    @Autowired
    private GrandParentRepository grandParentRepository;

    @Test
    public void shouldReturnAllGrandParentsWithTheirGrandChildren() {
        //GIVEN
        Operation operation = sequenceOf(
                insertInto("GRAND_PARENT")
                        .columns("ID", "NAME")
                        .values(1, "Bill")
                        .values(2, "Hillary")
                        .build(),
                insertInto("GRAND_CHILD")
                        .columns("ID", "NAME")
                        .values(4, "Eiden")
                        .values(3, "Sharlota")
                        .build(),
                insertInto("GRANDPA_TO_GRANDCHILD")
                        .columns("GRANDPA_ID", "GRANDCHILD_ID")
                        .values(1, 3)
                        .values(1, 4)
                        .values(2, 3)
                        .values(2, 4)
                        .build()
        );
        new DbSetup(destination, operation).launch();
        //WHEN
        List<GrandParent> grandParents = grandParentRepository.findAll();
        //THEN
        assertThat(grandParents).hasSize(2);
        grandParents.forEach(parent -> assertThat(parent.getGrandChildren()).hasSize(2));
    }
}
