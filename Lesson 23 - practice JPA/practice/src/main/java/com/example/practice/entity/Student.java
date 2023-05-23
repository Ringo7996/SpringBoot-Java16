package com.example.practice.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true,setterPrefix = "with")
public class Student {
    int id;
    String name;
    String clazz;
    String email;
}
