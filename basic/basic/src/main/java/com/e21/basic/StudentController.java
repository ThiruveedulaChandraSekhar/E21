package com.e21.basic;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> list = new ArrayList<>();

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return list;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {
        for(Student i : list) {
            if(i.getId() == id)
                return i;
        }
        return null;
    }

    @PostMapping("/student")
    public String addStudent(@RequestBody Student student) {
        student.setId(list.size() + 1);
        list.add(student);
        return "Student added successfully";
    }

}
