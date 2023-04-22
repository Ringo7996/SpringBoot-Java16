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
    private int id;
    private String name;
    private String description;
    private String type;
    private List<String> topics;
    private String thumbnail;
    private int userId;

}
