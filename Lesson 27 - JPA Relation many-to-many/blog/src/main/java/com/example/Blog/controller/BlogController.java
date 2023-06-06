package com.example.Blog.controller;


import com.example.Blog.entity.Blog;
import com.example.Blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/public")
public class BlogController {
    @Autowired
    private BlogService blogService;


    //1. Lấy danh sách blog public và sắp xếp theo thời gian public giảm dần (có phân trang)
    @GetMapping("/blogs")
    public Page<Blog> getAllPublicBlogs(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {
        return blogService.getAllPublicBlogs(page, pageSize);
    }


    //2. Tìm kiếm các bài blog đã public trong tên có chứa từ khóa cần tìm
    @GetMapping("/search")
    public List<Blog> searchBlogs(@RequestParam(name = "term") String term) {
        return blogService.searchBlogs(term);
    }


    //6. Lấy chi tiết bài viết
    @GetMapping("/blogs/{blogId}/{blogSlug}")
    public Blog getBlogByIdAndSlug(@PathVariable(name = "blogId") Integer id, @PathVariable(name = "blogSlug") String slug){
        return blogService.getBlogByIdAndSlug(id, slug);
    }
}
