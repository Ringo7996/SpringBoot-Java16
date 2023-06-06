package com.example.Blog.service;

import com.example.Blog.dto.CategoryDto;
import com.example.Blog.entity.Blog;
import com.example.Blog.entity.Category;
import com.example.Blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public List<CategoryDto> getTop5Categories() {
        return categoryRepository.getTop5Categories();
    }

    @Override
    public List<Blog> getBlogsByCategory(String name) {
        Category category = categoryRepository.findByName(name);
        return category.getBlogs();
    }
}
