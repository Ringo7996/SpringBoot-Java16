package com.example.Blog.controller;


import com.example.Blog.entity.Blog;
import com.example.Blog.service.BlogService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/blogs")
public class AdminBlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        return "/admin/blog/index";
    }


    @GetMapping("/index")
    public String getAllBlogs(@RequestParam(name = "page", defaultValue = "1") Integer page,
                              @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                              Model model) {
        Page<Blog> blogPage = blogService.getAllPost(page, pageSize);
        model.addAttribute("page", blogPage);
        model.addAttribute("currentPage", page);
        return "/admin/blog/blog-index";
    }

    @GetMapping("/own-blogs")
    public String getOwnBlogs(Model model) {

        List<Blog> blogList = blogService.getBlogsOfUser(1);
        model.addAttribute("blogList", blogList);
        return "/admin/blog/blog-yourself";
    }

    @GetMapping("/{id}/detail")
    public String getBlogDetail(@PathVariable Integer id, Model model) {
        Blog blog = blogService.getBlogById(id);
        if (blog == null) {
            return "pages/404";
        }

        model.addAttribute("blog", blog);
        return "/admin/blog/blog-detail";
    }

    @GetMapping("/blog-create")
    public String getBlogCreate(Model model) {
        return "/admin/blog/blog-create";
    }
}
