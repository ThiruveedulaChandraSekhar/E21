package com.e21.basic.service;

import com.e21.basic.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    List<Student> list = new ArrayList<>();

    public List<Student> getStudents() {
        return list;
    }

    public Student getStudentById(int id) {
        for(Student i : list) {
            if(i.getId() == id)
                return i;
        }
        return null;
    }

    public String addStudent(Student student) {
        student.setId(list.size() + 1);
        list.add(student);
        return "Student added successfully";
    }
}
