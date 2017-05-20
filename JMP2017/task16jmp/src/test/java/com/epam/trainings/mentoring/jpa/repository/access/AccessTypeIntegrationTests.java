
package com.epam.trainings.mentoring.jpa.repository.access;

import com.epam.trainings.mentoring.jpa.domain.access.FieldAccessType;
import com.epam.trainings.mentoring.jpa.domain.access.MixedAccessType;
import com.epam.trainings.mentoring.jpa.domain.access.PropertyAccessType;
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
public class AccessTypeIntegrationTests extends AbstractIntegrationTests {

	@Autowired
	private FieldAccessRepositoryImpl fieldAccessRepository;
	@Autowired
	private PropertyAccessRepositoryImpl propertyAccessRepository;
	@Autowired
	private MixedAccessRepositoryImpl mixedAccessRepository;

	@Test
	public void shouldReturnFieldAccessMappedEntity() {
		//GIVEN
		Operation operation = insertInto("FIELD_ACCESS_TYPE")
				.withGeneratedValue("ID", ValueGenerators.sequence())
				.columns("NAME")
				.values("First")
				.build();
		new DbSetup(destination, operation).launch();
		//WHEN
		List<FieldAccessType> values = this.fieldAccessRepository.findAll();
		//THEN
		assertThat(values).hasSize(1);
	}

	@Test
	public void shouldReturnPropertyAccessMappedEntity() {
		//GIVEN
		Operation operation = insertInto("PROPERTY_ACCESS_TYPE")
				.withGeneratedValue("ID", ValueGenerators.sequence())
				.columns("NAME")
				.values("First")
				.build();
		new DbSetup(destination, operation).launch();
		//WHEN
		List<PropertyAccessType> values = this.propertyAccessRepository.findAll();
		//THEN
		assertThat(values).hasSize(1);
	}

	@Test
	public void shouldReturnMixedAccessMappedEntity() {
		//GIVEN
		Operation operation = insertInto("MIXED_ACCESS_TYPE")
				.withGeneratedValue("ID", ValueGenerators.sequence())
				.columns("NEW_NAME", "DESCRIPTION")
				.values("First", "Hibernate is better than JPA =)")
				.build();
		new DbSetup(destination, operation).launch();
		//WHEN
		List<MixedAccessType> values = this.mixedAccessRepository.findAll();
		//THEN
		assertThat(values).hasSize(1);
	}

}
