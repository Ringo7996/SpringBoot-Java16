package com.example.Blog.service;

import com.example.Blog.dto.CategoryDto;
import com.example.Blog.entity.Blog;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();

    List<CategoryDto> getTop5Categories();

    List<Blog> getBlogsByCategory(String name);
}
