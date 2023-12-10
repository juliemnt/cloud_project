package fr.efrei.server.service;

import fr.efrei.server.domain.Student;
import fr.efrei.server.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id){
        return studentRepository.findById(id)
                .orElse(null);
    }

    public Student createOneStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateOneStudent(Student student){
        return studentRepository.save(student);
    }

    public Integer deleteOneStudent(Integer id){
        studentRepository.deleteById(id);
        return 1;
    }
}
