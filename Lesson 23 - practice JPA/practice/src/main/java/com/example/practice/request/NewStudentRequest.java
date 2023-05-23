package com.example.practice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewStudentRequest {
    String name;
    String clazz;
    String email;
}
