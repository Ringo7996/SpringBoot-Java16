package com.example.Blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String admin(){
        return "admin/blog/index";
    }

    @GetMapping("/blog-create")
    public String blogCreate(){
        return "admin/blog/blog-create";
    }

    @GetMapping("/blog-detail")
    public String blogDetail(){
        return "admin/blog/blog-detail";
    }

    @GetMapping("/blog-index")
    public String blogIndex(){
        return "admin/blog/blog-index";
    }

    @GetMapping("/blog-yourself")
    public String blogYourself(){
        return "admin/blog/blog-yourself";
    }



}
