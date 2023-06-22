package com.example.Blog.controller;

import com.example.Blog.entity.Blog;
import com.example.Blog.entity.Category;
import com.example.Blog.service.BlogService;
import com.example.Blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin/categories")
public class WAdminCategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/index")
    public String getAllCategories(@RequestParam(name = "page", defaultValue = "1") Integer page,
                              @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                              Model model) {
        Page<Category> categoryPage = categoryService.getAllCategories(page, pageSize);
        model.addAttribute("page", categoryPage);
        model.addAttribute("currentPage", page);
        return "";
    }
}
