package com.springboot.springbootrestapi.controller;

import com.springboot.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    // returning java bean as student as JSON
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Ganavi",
                "Jayaram"
        );
        //return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok()
                .header("Ganavi", "header")
                .body(student);
    }


    // returning list as JSON
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1,"Ganavi", "Jayaram"));
        students.add(new Student(2,"Jayaram", "KL"));
        students.add(new Student(3,"Prathibha", "CN"));
        students.add(new Student(4,"Sachin", "Gowda"));

        return ResponseEntity.ok(students);
    }

    // Handling path variables
    //http://localhost:8080/students/1/Ganavi/Jayaram
    @GetMapping("/{id}/{firstName}/{lastName}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable String firstName,
                                       @PathVariable String lastName) {

        return ResponseEntity.ok(new Student(studentId,firstName, lastName));
    }

    //using requestParam
    //http://localhost:8080/students/query?id=1&firstName=GANAVI&lastName=JAYARAM
    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestParan(@RequestParam int id,
                                       @RequestParam String firstName,
                                       @RequestParam String lastName){
        return ResponseEntity.ok(new Student(id, firstName, lastName));
    }

    //POST Request
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //POST Request
    @PutMapping("/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentId) {
        return ResponseEntity.ok(student);
    }

    //POST Request
    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        return ResponseEntity.ok("Student Deleted!");
    }


}
