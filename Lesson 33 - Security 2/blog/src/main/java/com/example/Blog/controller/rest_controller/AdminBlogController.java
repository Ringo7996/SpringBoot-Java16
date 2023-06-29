package com.example.Blog.controller.rest_controller;


import com.example.Blog.entity.Blog;
import com.example.Blog.request.UpsertBlogRequest;
import com.example.Blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/admin/blogs")
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR')")
public class AdminBlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping()
    public Blog upsertBlog(@RequestBody UpsertBlogRequest request){
        Blog blog = blogService.upsertBlog(request);
        return blog;
    }


    @PutMapping("/{id}")
    public Blog updateBlog(@RequestBody UpsertBlogRequest request, @PathVariable Integer id){
        Blog blog = blogService.updateBlog(request,id);
        return blog;
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Integer id){
        blogService.deleteBlog(id);
    }

}
