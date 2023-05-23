package com.example.practice.service;

import com.example.practice.entity.Student;
import com.example.practice.repository.StudentRepository;
import com.example.practice.request.NewStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Student addANewStudent(NewStudentRequest request) {
        return studentRepository.addANewStudent(request);
    }
}
