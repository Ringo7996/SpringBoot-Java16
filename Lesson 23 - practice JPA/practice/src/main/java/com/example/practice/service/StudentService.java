package com.example.practice.service;

import com.example.practice.entity.Student;
import com.example.practice.request.NewStudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student addANewStudent(NewStudentRequest request);
}
