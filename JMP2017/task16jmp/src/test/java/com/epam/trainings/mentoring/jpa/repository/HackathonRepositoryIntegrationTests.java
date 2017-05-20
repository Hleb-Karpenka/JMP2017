
package com.epam.trainings.mentoring.jpa.repository;

import com.epam.trainings.mentoring.jpa.domain.Hackathon;
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
public class HackathonRepositoryIntegrationTests extends AbstractIntegrationTests {
	@Autowired
	private HackathonRepositoryImpl repository;

	@Test
	public void findsAllShouldReturnAllRecords() {
		//GIVEN
		Operation operation = insertInto("HACKATHON")
				.withGeneratedValue("ID", ValueGenerators.sequence())
				.columns("NAME", "DESCRIPTION")
				.values("Say my name!", "Mr. Heisenberg")
				.values("And name of my friend!", "jesse pinkman")
				.build();
		new DbSetup(destination, operation).launch();
		//WHEN
		List<Hackathon> hackathons = this.repository.findAll();
		//THEN
		assertThat(hackathons).hasSize(2);
	}

}
