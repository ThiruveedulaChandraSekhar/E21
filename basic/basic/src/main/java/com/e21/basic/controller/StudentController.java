package com.e21.basic.controller;

import com.e21.basic.model.Student;
import com.e21.basic.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;


    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> response = service.getStudents();
        return response;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

}
