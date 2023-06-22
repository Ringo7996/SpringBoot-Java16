package com.example.Blog.controller;


import com.example.Blog.dto.CategoryDto;
import com.example.Blog.entity.Blog;
import com.example.Blog.service.BlogService;
import com.example.Blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class WebController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;


    //1. Lấy danh sách blog public và sắp xếp theo thời gian public giảm dần (có phân trang)
    @GetMapping("/")
    public String getAllPublicBlogs(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                    @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                                    Model model) {

        Page<Blog> publicPage = blogService.getAllPublicBlogs(page, pageSize);
        List<CategoryDto> categoryDtoList = categoryService.getAllCategories();

        model.addAttribute("page", publicPage);
        model.addAttribute("categoryList", categoryDtoList);
        model.addAttribute("currentPage", page);

        return "web/main";
    }


    //2. Tìm kiếm các bài blog đã public trong tên có chứa từ khóa cần tìm
    @GetMapping("/search")
    public String searchBlogs(@RequestParam(name = "term", required = false) String term, Model model) {
        List<Blog> blogList = blogService.searchBlogs(term);
        model.addAttribute("blogList", blogList);
        model.addAttribute("term", term);
        return "web/search";
    }


    //5. Lấy danh sách bài viết áp dụng category
    @GetMapping("/categories/{categoryName}")
    public String getBlogsByCategory(@PathVariable String categoryName, Model model) {
        List<Blog> blogList = categoryService.getBlogsByCategory(categoryName);
        model.addAttribute("category", categoryName);
        model.addAttribute("blogList", blogList);
        return "web/tagDetail";
    }

    //3. Lấy danh sách category
    @GetMapping("/categories")
    public String getAllCategories(Model model) {
        List<CategoryDto> categoryList = categoryService.getAllCategories();

        model.addAttribute("categoryList", categoryList);
        return "web/tag";
    }


    //6. Lấy chi tiết bài viết
    @GetMapping("/blogs/{blogId}/{blogSlug}")
    public String getBlogByIdAndSlug(@PathVariable(name = "blogId") Integer id,
                                     @PathVariable(name = "blogSlug") String slug,
                                     Model model) {
        Blog blog = blogService.getBlogByIdAndSlug(id, slug);
        model.addAttribute(blog);
        return "web/blogdetail";
    }



}
