package com.example.Blog.service;

import com.example.Blog.dto.CategoryDto;
import com.example.Blog.entity.Blog;
import com.example.Blog.entity.Category;
import com.example.Blog.request.UpsertCategoryRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();

    List<CategoryDto> getTop5Categories();

    List<Blog> getBlogsByCategory(String name);

    CategoryDto upsertCategory(UpsertCategoryRequest request);

    CategoryDto updateCategory(UpsertCategoryRequest request, Integer id);

    void deleteCategory(Integer id);

    Page<Category> getAllCategories(Integer page, Integer pageSize);


    CategoryDto getCategoryById(Integer id);
}
