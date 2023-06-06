package com.example.Blog.service;

import com.example.Blog.entity.Blog;
import com.example.Blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImp implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> getAllPublicBlogs(Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        return blogRepository.findByStatusOrderByPublishedAtDesc(true, pageRequest);
    }

    @Override
    public List<Blog> searchBlogs(String term) {
        return blogRepository.findByStatusAndTitleContainsIgnoreCase(true, term);
    }



    @Override
    public Blog getBlogByIdAndSlug(Integer id, String slug) {
        return blogRepository.findByIdAndSlugAndStatus(id, slug, true);
    }
}
