
package com.epam.trainings.mentoring.jpa.repository;

import com.epam.trainings.mentoring.jpa.domain.ProjectIdea;
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
public class ProjectIdeaRepositoryIntegrationTests extends AbstractIntegrationTests {

	@Autowired
	private ProjectIdeaRepositoryImpl repository;

	@Test
	public void findsAllShouldReturnAllProjectIdeasForAllHackathons() {
		//GIVEN
		Operation operation = insertInto("PROJECT_IDEA")
				.withGeneratedValue("ID", ValueGenerators.sequence())
				.columns("NAME")
				.values("Hi! My name is!")
				.build();
		new DbSetup(destination, operation).launch();
		//WHEN
		List<ProjectIdea> projectIdeas = this.repository.findAll();
		//THEN
		assertThat(projectIdeas).hasSize(1);
	}

}
