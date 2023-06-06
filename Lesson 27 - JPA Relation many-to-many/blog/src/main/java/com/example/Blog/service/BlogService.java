package com.example.Blog.service;

import com.example.Blog.entity.Blog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BlogService {
    Page<Blog> getAllPublicBlogs(Integer page, Integer pageSize);

    List<Blog> searchBlogs(String term);

    Blog getBlogByIdAndSlug(Integer id, String slug);
}
