package fr.efrei.server.domain;

import jakarta.persistence.*;

@Entity
public class Student {
    //create entity Student
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencegenerator")
    @SequenceGenerator(name = "sequencegenerator")
    private Integer id;

    private String name;

    private Integer age;

    //public class Student
    public Student(){
    }

    //getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
