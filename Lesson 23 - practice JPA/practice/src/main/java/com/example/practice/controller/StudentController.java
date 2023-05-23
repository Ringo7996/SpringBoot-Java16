package com.example.practice.controller;

import com.example.practice.entity.Student;
import com.example.practice.request.NewStudentRequest;
import com.example.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student addANewStudent(@RequestBody NewStudentRequest request) {
        return studentService.addANewStudent(request);
    }

}
