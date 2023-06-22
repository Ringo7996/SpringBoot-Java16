package com.example.Blog.controller.rest_controller;


import com.example.Blog.dto.CategoryDto;
import com.example.Blog.entity.Blog;
import com.example.Blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/public")
public class UserCategoryController {
    @Autowired
    private CategoryService categoryService;
    //3. Lấy danh sách category
    @GetMapping("/categories")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    //4. Lấy danh sách category được sử dụng nhiều nhất
    @GetMapping("/category/top5")
    public List<CategoryDto> getTop5Categories() {
        return categoryService.getTop5Categories();
    }


    //5. Lấy danh sách bài viết áp dụng category
    @GetMapping("/category/{categoryName}")
    public List<Blog> getBlogsByCategory(@PathVariable String categoryName){
        return categoryService.getBlogsByCategory(categoryName);
    }


}
