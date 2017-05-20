package com.epam.trainings.mentoring.jpa.repository.relationship.onetoone;


import com.epam.trainings.mentoring.jpa.domain.relationship.onetoone.Student;
import com.epam.trainings.mentoring.jpa.domain.relationship.onetoone.StudentAddress;
import com.epam.trainings.mentoring.jpa.repository.AbstractIntegrationTests;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StudentRepositoryIntegrationTests extends AbstractIntegrationTests {
    @Autowired
    private StudentRepository studentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void saveShouldSaveStudentAndAddressWhenBothArePresent() {
        //GIVEN
        StudentAddress address = new StudentAddress();
        address.setStreet("Stroiteley");
        address.setHouse(56);
        Student student = new Student();
        student.setName("Arkady Dobkin");
        student.setAddress(address);
        //WHEN
        studentRepository.save(student);
        //THEN
        List<Student> students =  entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        assertThat(students).hasSize(1);
        Student savedStudent = students.get(0);
        assertThat(savedStudent.getAddress().getId()).isEqualTo(savedStudent.getId());
    }
}
