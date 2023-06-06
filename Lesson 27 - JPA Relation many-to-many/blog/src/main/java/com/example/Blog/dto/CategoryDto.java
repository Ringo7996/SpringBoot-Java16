package com.example.Blog.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryDto {
    private Integer id;
    private String name;
    private Long used;
}
