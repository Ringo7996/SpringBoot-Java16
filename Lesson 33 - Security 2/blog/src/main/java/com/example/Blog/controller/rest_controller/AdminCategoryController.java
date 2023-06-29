package com.example.Blog.controller.rest_controller;

import com.example.Blog.dto.CategoryDto;
import com.example.Blog.entity.Blog;
import com.example.Blog.repository.CategoryRepository;
import com.example.Blog.request.UpsertBlogRequest;
import com.example.Blog.request.UpsertCategoryRequest;
import com.example.Blog.service.BlogService;
import com.example.Blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/categories")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;
    @PreAuthorize("hasRole('ROLE_AUTHOR')")
    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Integer id) {
        CategoryDto categoryDto = categoryService.getCategoryById(id);
        return categoryDto;
    }


    @PostMapping("")
    public CategoryDto upsertCategory(@RequestBody UpsertCategoryRequest request) {
        CategoryDto categoryDto = categoryService.upsertCategory(request);
        return categoryDto;
    }


    @PutMapping("/{id}")
    public CategoryDto updateCategory(@RequestBody UpsertCategoryRequest request, @PathVariable Integer id) {
        CategoryDto categoryDto = categoryService.updateCategory(request, id);
        return categoryDto;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }
}
