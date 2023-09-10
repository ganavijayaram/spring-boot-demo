package com.springboot.springbootrestapi.controller;

import com.springboot.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // Handling path variables
    //http://localhost:8080/students/1/Ganavi/Jayaram
    @GetMapping("/students/{id}/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable String firstName,
                                       @PathVariable String lastName) {

        return new Student(studentId,firstName, lastName);
    }

    //using requestParam
    //http://localhost:8080/students/query?id=1&firstName=GANAVI&lastName=JAYARAM
    @GetMapping("/students/query")
    public Student studentRequestParan(@RequestParam int id,
                                       @RequestParam String firstName,
                                       @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

    //POST Request
    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return student;
    }

    //POST Request
    @PutMapping("/students/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentId) {
        return student;
    }

    //POST Request
    @DeleteMapping("/students/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteStudent(@PathVariable("id") int studentId) {
        return "Student Deleted!";
    }


}
