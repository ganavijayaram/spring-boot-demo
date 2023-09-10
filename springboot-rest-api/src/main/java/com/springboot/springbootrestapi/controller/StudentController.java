package com.springboot.springbootrestapi.controller;

import com.springboot.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // returning java bean as student as JSON
    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "Ganavi",
                "Jayaram"
        );
        return student;
    }


    // returning list as JSON
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1,"Ganavi", "Jayaram"));
        students.add(new Student(2,"Jayaram", "KL"));
        students.add(new Student(3,"Prathibha", "CN"));
        students.add(new Student(4,"Sachin", "Gowda"));

        return students;
    }

}
