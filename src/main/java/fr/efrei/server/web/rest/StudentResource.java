package fr.efrei.server.web.rest;

import fr.efrei.server.domain.Student;
import fr.efrei.server.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentResource {

    public final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getOneStudent (@PathVariable String id) {

        Student student = new Student();

        student = studentService.getStudentById(Integer.parseInt(id));

        return student;
    }

    //localhost:8080/api/student/create?name=John&age=22
    @PostMapping("/student/create")
    public Student createOneStudent (@RequestParam String name, @RequestParam Integer age) {
        Student student = new Student();

        student.setName(name);
        student.setAge(age);

        student = studentService.createOneStudent(student);

        return student;

    }

    @PutMapping("/student/update")
    public Student updateOneStudent (@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age) {
        Student student = new Student();

        student.setId(id);
        student.setName(name);
        student.setAge(age);

        student = studentService.updateOneStudent(student);

        return student;
    }

    @DeleteMapping("/student/delete/{id}")
    public Integer deleteOneStudent (@PathVariable Integer id) {
        return studentService.deleteOneStudent(id);
    }
}
