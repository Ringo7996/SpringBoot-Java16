package com.example.Blog.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CategoryDto {
    private Integer id;
    private String name;
    private Long used;
}
