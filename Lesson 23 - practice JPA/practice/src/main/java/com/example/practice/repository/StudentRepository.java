package com.example.practice.repository;

import com.example.practice.entity.Student;
import com.example.practice.request.NewStudentRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    public List<Student> getAllStudents() {
        return StudentDB.students;
    }

    public Student addANewStudent(NewStudentRequest request) {
        int newSize = StudentDB.size++;
        Student newStudent = Student.builder().withId(newSize).withName(request.getName()).withClazz(request.getClazz()).withEmail(request.getEmail()).build();
        StudentDB.students.add(newStudent);
        return newStudent;
    }
}
