package fr.efrei.server.web.rest;

import fr.efrei.server.domain.Student;
import fr.efrei.server.repository.StudentRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StudentUnitTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    void readStudent() throws Exception{
        int size = studentRepository.findAll().size();
        assertThat(size).isEqualTo(4);
    }

    @Test
    @Transactional
    void getOneStudent() throws Exception{
        Student studentFound = studentRepository.findById(0).orElse(null);
        assertThat(studentFound.getId()).isEqualTo(0);
        assertThat(studentFound.getName()).isEqualTo("BENJAMIN");
        assertThat(studentFound.getAge()).isEqualTo(22);
    }

    @Test
    @Transactional
    void createOneStudent() throws Exception{
        Student newStudent = new Student();
        newStudent.setName("CHLOE");
        newStudent.setAge(22);
        Student createdStudent = studentRepository.save(newStudent);
        assertThat(createdStudent.getId()).isEqualTo(4);
        assertThat(createdStudent.getName()).isEqualTo("CHLOE");
        assertThat(createdStudent.getAge()).isEqualTo(22);
    }

    @Test
    @Transactional
    void updateOneStudent() throws Exception{
        Student studentFound = studentRepository.findById(0).orElse(null);
        studentFound.setName("MARGAUX");
        studentFound.setAge(20);
        studentRepository.save(studentFound);
        Student studentUpdated = studentRepository.findById(0).orElse(null);
        assertThat(studentUpdated.getName()).isEqualTo("MARGAUX");
        assertThat(studentUpdated.getAge()).isEqualTo(20);
    }

    @Test
    @Transactional
    void deleteOneStudent() throws Exception{
        studentRepository.deleteById(0);
        assertThat(studentRepository.findAll().size()).isEqualTo(3);
    }
}