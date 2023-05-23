package com.example.practice.repository;

import com.example.practice.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class StudentDB {
    public static int size = 4;
    public static List<Student> students = new ArrayList<>(Arrays.asList(
            Student.builder().withId(1).withName("Student1").withClazz("A1").withEmail("st1@gmail.com").build(),
            Student.builder().withId(2).withName("Student2").withClazz("B4").withEmail("st2@gmail.com").build(),
            Student.builder().withId(3).withName("Student3").withClazz("C6").withEmail("st3@gmail.com").build()
    ));

}
