package com.example.APIUser.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Course {
    int id;
    String name;
    String description;
    String type;
    List<String> topics;
    String thumbnail;
    int userId;

}
