package com.springboot.springbootrestapi.controller;

import com.springboot.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    // returning bean
    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "Ganavi",
                "Jayaram"
        );
        return student;
    }

}
