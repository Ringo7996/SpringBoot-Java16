package com.example.Blog.service;

import com.example.Blog.entity.Blog;
import com.example.Blog.request.UpsertBlogRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BlogService {
    Page<Blog> getAllPublicBlogs(Integer page, Integer pageSize);

    List<Blog> searchBlogs(String term);

    Blog getBlogByIdAndSlug(Integer id, String slug);

    Page<Blog> getAllPost(Integer page, Integer pageSize);

    List<Blog> getBlogsOfUser(Integer userId);

    Blog upsertBlog(UpsertBlogRequest request);

    Blog updateBlog(UpsertBlogRequest request, Integer id);

    void deleteBlog(Integer id);

    Blog getBlogById(Integer blogId);
}
